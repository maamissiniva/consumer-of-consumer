package maamissiniva.function.coc;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

// Proof of concept, this is more a code sample than
// a test.

public class TestFiles {
    
    // Using directory, should clear the directory content,
    // lazy implementation at the moment.
    public static CC1<Path> withTmpDirectory(String prefix) {
        return nc -> {
            Path p = Files.createTempDirectory(prefix);
            System.out.println("created temp directory " + p);
            try {
                nc.accept(p);
            } finally {
                Files.delete(p);
                System.out.println("deleted temp directory " + p);
            }
        };
    }
    
    // Use a temporary file in some directory
    public static CC1<Path> withTmpFile(Path path, String prefix, String suffix) {
        return nc -> {
            Path p = Files.createTempFile(path, prefix, suffix);
            System.out.println("created temp file " + p);
            try {
                nc.accept(p);
            } finally {
                Files.delete(p);
                System.out.println("deleted temp file " + p);
            }           
        };
    }
    
    public static CC1<Path> withFile(Path path, String name) {
        return withFile(path,name,new byte[0]);
    }
    
    // Use a named file with some content in some directory.
    public static CC1<Path> withFile(Path path, String name, byte[] content) {
        return nc -> {
            Path p = path.resolve(name);
            Files.write(p, content);
            System.out.println("created file " + p);
            try {
                nc.accept(p);
            } finally {
                Files.delete(p);
                System.out.println("deleted file " + p);
            }           
        };
    }
    
    // Prepare 2 tmp files
    public static final CC2<Path,Path> twoTmpFiles =
            withTmpDirectory("cctest")
            .nest(dir      -> withTmpFile(dir,"ccfile","suffix"))
            .nest((dir,f0) -> withTmpFile(dir,"ccfile","suffix"))
            .cc2((dir,f0,f1) -> new T2<>(f0,f1));
   
    // Prepare 2 named files in a temp directory
    public static final CC2<Path,Path> twoFiles =
            withTmpDirectory("cctest")
            .nest(dir      -> withFile(dir,"firstfile"))
            .nest((dir,f0) -> withFile(dir,"secondfile"))
            .cc2((dir,f0,f1) -> new T2<>(f0,f1));
    
    @Test
    public void test_00() throws Exception {
        List<Path> created = new ArrayList<>();
        withTmpDirectory("cctest")
        .nest(dir -> withTmpFile(dir,"ccfile","suffix"))
        .accept((dir,file) -> {
            System.out.println("temp directory : " + dir);
            System.out.println("temp file      : " + file);
            created.add(dir);
            created.add(file);
            assertTrue(Files.exists(dir));
            assertTrue(Files.exists(file));
        });
        for (Path p : created)
            assertFalse(Files.exists(p));
    }
    
    @Test
    public void test_01() throws Exception {
        List<Path> created = new ArrayList<>();
        withTmpDirectory("cctest")
        .nest(dir      -> withTmpFile(dir,"ccfile","suffix"))
        .nest((dir,f0) -> withTmpFile(dir,"ccfile","suffix"))
        .accept((dir,f0,f1) -> {
            System.out.println("temp directory : " + dir);
            System.out.println("temp file 0    : " + f0);
            System.out.println("temp file 1    : " + f1);
            created.add(dir);
            created.add(f0);
            created.add(f1);
            assertTrue(Files.exists(dir));
            assertTrue(Files.exists(f0));
            assertTrue(Files.exists(f1));
        });
        for (Path p : created)
            assertFalse(Files.exists(p));
    }

    @Test
    public void test_02() throws Exception {
        twoTmpFiles.accept((f0,f1) -> {
            System.out.println("using files " + f0 + " and " + f1);
        });
    }
    
    @Test
    public void test_03() throws Exception {
        twoFiles.accept((f0,f1) -> {
            System.out.println("using files " + f0 + " and " + f1);
        });
    }
    
    @Test
    public void test_04() throws Exception {
        twoFiles.accept((f0,f1) -> {
            System.out.println("using files " + f0 + " and " + f1);
        });
    }
   
}

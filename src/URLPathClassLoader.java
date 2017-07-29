import java.net.URL;
import java.net.URLClassLoader;

/**
 * Created by li on 17-6-26.
 */
public class URLPathClassLoader extends URLClassLoader {
    private String packageName = "cn.godbol.classloader";

    public URLPathClassLoader(URL[] urls, ClassLoader parent) {
        super(urls, parent);
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        Class<?> aClass = findLoadedClass(name);
        if (aClass != null) {
            return aClass;
        }
        if (!packageName.startsWith(name)) {
            return super.loadClass(name);
        } else {
            return findClass(name);
        }
    }
}

package com.github.bakabbq;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.Array;
import org.jruby.embed.ScriptingContainer;

/**
 * Created by LBQ on 8/19/14.
 *
 * Integration layer of JRuby
 */
public class JRubyClassLoader {
    private static ScriptingContainer container = new ScriptingContainer();
    public static Object loadClass(String filename){
        String content = Gdx.files.internal("scripts/" + filename + ".rb").readString();
        container.setClassLoader(JRubyClassLoader.class.getClassLoader());
        container.runScriptlet(content); // load the class
        Object actualObject = container.runScriptlet(filename + ".new");
        return actualObject;
    }

    public static void loadLibrary(String filename){
        String content = Gdx.files.internal("scripts/" + filename + ".rb").readString();
        container.setClassLoader(JRubyClassLoader.class.getClassLoader());
        container.runScriptlet(content); // load the class
    }

    public static Object exec(String str){
        return container.runScriptlet(str);
    }

    public static Object callMethod(Object target, String methodName, Object... params){
        return container.callMethod(target,methodName,params);
    }


}

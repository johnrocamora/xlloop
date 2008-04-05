package org.boris.functionserver;

import java.io.File;

import org.boris.functionserver.reflect.ReflectFunctionHandler;
import org.boris.functionserver.reflect.ReflectRequestHandler;
import org.boris.functionserver.script.ScriptRepository;
import org.boris.functionserver.util.CompositeFunctionHandler;
import org.boris.functionserver.util.DebugFunctionHandler;

public class ServerTest1 {
    public static void main(String[] args) throws Exception {
        FunctionServer fs = new FunctionServer();
        ReflectFunctionHandler rfh = new ReflectFunctionHandler();
        ScriptRepository srep = new ScriptRepository(new File("functions"),
                "Script.");
        rfh.addMethods("Math.", Math.class);
        rfh.addMethods("CSV.", CSV.class);
        CompositeFunctionHandler cfh = new CompositeFunctionHandler();
        cfh.add(rfh);
        cfh.add(srep);
        fs.setFunctionHandler(new DebugFunctionHandler(cfh));
        fs.setRequestHandler(new ReflectRequestHandler(rfh));
        fs.run();
    }
}

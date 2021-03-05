package ro.ase.acs.main;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class IoC {
    private Map<Class<?>, Class<?>> map = new HashMap<>();

    public void register(Class<?> contract, Class<?> implementation){
        if(!map.containsKey(contract)){
            map.put(contract,implementation);
        }
    }

    public <T> T resolve () throws NoSuchMethodException {
        Method m = this.getClass().getMethod("resolve");
        return (T) map.get(m.getReturnType());
    }
}

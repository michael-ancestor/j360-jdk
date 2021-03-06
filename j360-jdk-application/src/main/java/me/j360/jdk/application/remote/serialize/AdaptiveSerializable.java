package me.j360.jdk.application.remote.serialize;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class AdaptiveSerializable implements RemotingSerializable {

    private final static Logger LOGGER = LoggerFactory.getLogger(RemotingSerializable.class);

    private static volatile String defaultSerializable;

    private static final Map<Integer, RemotingSerializable>
            ID_SERIALIZABLE_MAP = new HashMap<Integer, RemotingSerializable>();

    static {
        /*Set<String> names = ExtensionLoader.getExtensionLoader(RemotingSerializable.class).getSupportedExtensions();
        for (String name : names) {
            if (!"adaptive".equalsIgnoreCase(name)) {
                RemotingSerializable serializable = ExtensionLoader
                        .getExtensionLoader(RemotingSerializable.class).getExtension(name);
                ID_SERIALIZABLE_MAP.put(serializable.getId(), serializable);
            }
        }*/
    }

    public static RemotingSerializable getSerializableById(int id) {
        return ID_SERIALIZABLE_MAP.get(id);
    }

    public static void setDefaultSerializable(String defaultSerializable) {
        AdaptiveSerializable.defaultSerializable = defaultSerializable;
        LOGGER.info("Using defaultSerializable [{}]", defaultSerializable);
    }

    private RemotingSerializable getRemotingSerializable() {
        RemotingSerializable remotingSerializable = null;

        /*ExtensionLoader<RemotingSerializable> loader = ExtensionLoader.getExtensionLoader(RemotingSerializable.class);
        String serializable = defaultSerializable; // copy reference
        if (serializable != null) {
            remotingSerializable = loader.getExtension(serializable);
        } else {
            remotingSerializable = loader.getDefaultExtension();
        }*/
        return remotingSerializable;
    }

    @Override
    public int getId() {
        return getRemotingSerializable().getId();
    }

    @Override
    public byte[] serialize(Object obj) throws Exception {
        return getRemotingSerializable().serialize(obj);
    }

    @Override
    public <T> T deserialize(byte[] data, Class<T> clazz) throws Exception {
        return getRemotingSerializable().deserialize(data, clazz);
    }
}

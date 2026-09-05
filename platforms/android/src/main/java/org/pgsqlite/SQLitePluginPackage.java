package org.pgsqlite;

import androidx.annotation.Nullable;

import com.facebook.react.TurboReactPackage;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.module.model.ReactModuleInfo;
import com.facebook.react.module.model.ReactModuleInfoProvider;

import java.util.HashMap;
import java.util.Map;

public class SQLitePluginPackage extends TurboReactPackage {

    @Nullable
    @Override
    public NativeModule getModule(String name, ReactApplicationContext reactContext) {
        if (name.equals(SQLitePlugin.PLUGIN_NAME)) {
            return new SQLitePlugin(reactContext);
        }
        return null;
    }

    @Override
    public ReactModuleInfoProvider getReactModuleInfoProvider() {
        return () -> {
            final Map<String, ReactModuleInfo> moduleInfos = new HashMap<>();
            moduleInfos.put(
                    SQLitePlugin.PLUGIN_NAME,
                    new ReactModuleInfo(
                            SQLitePlugin.PLUGIN_NAME,
                            SQLitePlugin.class.getName(),
                            false,
                            false,
                            false,
                            false,
                            false
                    )
            );
            return moduleInfos;
        };
    }
}

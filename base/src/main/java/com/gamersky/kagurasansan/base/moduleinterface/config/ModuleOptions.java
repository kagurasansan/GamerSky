package com.gamersky.kagurasansan.base.moduleinterface.config;

import android.content.Context;

public class ModuleOptions {

    private ModuleOptions.ModuleBuilder builder;

    private ModuleOptions(ModuleOptions.ModuleBuilder builder) {
        this.builder = builder;
    }

    public boolean hasModule(String key) {
        return builder.containModule(key);
    }

    public String getModule(String key) {
        return builder.getModuleEntrance(key);
    }

    public Context getContext() {
        return builder.context;
    }

    public static class ModuleBuilder {
        private Context context;
        private ImmutableMap mModules;

        public ModuleBuilder(Context context) {
            this.context = context;
            mModules = new ImmutableMap();
        }

        public ModuleOptions.ModuleBuilder addModule(String key, String value) {
            mModules.add(key, value);
            return this;
        }

        public boolean containModule(String key) {
            return mModules.containsKey(key);
        }

        public String getModuleEntrance(String key) {
            return mModules.get(key);
        }

        public ModuleOptions build() {
            return new ModuleOptions(this);
        }

    }
}

package com.gamersky.kagurasansan.base.moduleinterface.route;


import com.gamersky.kagurasansan.base.moduleinterface.config.ModuleOptions;

public class ModuleManager {

    private ModuleOptions options;

    private ModuleManager() {
    }

    private static class ModuleManagerHolder {
        private static final ModuleManager instance = new ModuleManager();
    }

    public static ModuleManager getInstance() {
        return ModuleManagerHolder.instance;

    }

    public void init(ModuleOptions options) {
        if (this.options == null && options != null) {
            this.options = options;
        }
    }

    public ModuleOptions getOptions() {
        return options;
    }

    public boolean hasModule(String key) {
        return options.hasModule(key);
    }

}

package com.frankinz.disablewheel;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.MouseEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.event.RegistryEvent;

@Mod(
        modid = DisableWheel.MOD_ID,
        name = DisableWheel.MOD_NAME,
        version = DisableWheel.VERSION
)
public class DisableWheel {

    public static final String MOD_ID = "disablewheel";
    public static final String MOD_NAME = "DisableWheel";
    public static final String VERSION = "1.13.2";

    /**
     * This is the instance of your mod as created by Forge. It will never be null.
     */
    @Mod.Instance(MOD_ID)
    public static DisableWheel INSTANCE;

    /**
     * This is the second initialization event. Register custom recipes
     */
    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        // Register the event handler
        MinecraftForge.EVENT_BUS.register(new MyMouseEventHandler());
    }

    /**
     * The mouse event handler
     */
    class MyMouseEventHandler{

        @SubscribeEvent
        public void mouseClickd(MouseEvent event){

            if (event.getButton() == -1){
                event.setCanceled(true);
            }
        }
    }
}

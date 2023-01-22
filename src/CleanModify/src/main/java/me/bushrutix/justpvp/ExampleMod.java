package me.bushrutix.justpvp;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import java.io.*;
import java.net.Socket;

@Mod("examplemod")
public class ExampleMod {
    String sss = "bushrutixxxxxx on the beat";
    private static double ttf = 0.3;
    private static BufferedReader in;
    public ExampleMod() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event) {
        try {
            Socket socket = new Socket("localhost", 7777);

            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            new Thread(() -> {
                while (true) {
                    try {
                        if (in.readLine() != null) {
                            ttf = Double.parseDouble(in.readLine());
                            System.out.println(ttf);
                        }
                    } catch (IOException ignored) {}
                }
            }).start();
        } catch (IOException ignored) {}
    }

    @SubscribeEvent
    public void onlifegoeson(RenderPlayerEvent bbbadddoo) {
        Entity p = bbbadddoo.getEntity();

        if (p != Minecraft.getInstance().player) {
            p.setBoundingBox(new AxisAlignedBB(
                    p.getX() - ttf,
                    p.getBoundingBox().minY,
                    p.getZ() - ttf,
                    p.getX() + ttf,
                    p.getBoundingBox().maxY,
                    p.getZ() + ttf
            ));
        }
    }
}

package ru.winside.testmod;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import net.minecraft.potion.Potion;
import net.minecraftforge.common.MinecraftForge;
import ru.winside.testmod.items.Ak74;
import ru.winside.testmod.items.JustItem;
import ru.winside.testmod.proxies.ClientProxy;
import ru.winside.testmod.proxies.CommonProxy;
import ru.winside.testmod.utils.ArmRotation;
import ru.winside.testmod.utils.TestModEventHooks;
import ru.winside.testmod.utils.TestModPotion;

@Mod(modid = Main.MODID, version = Main.VERSION, name = Main.NAME)
public class Main {
	
	@Instance(Main.MODID)
	public static Main instance;
	
	public static final String MODID = "winsidemods";
    public static final String VERSION = "1.0";
    public static final String NAME = "WinSide Test Mod";
	
	public static Item justItem;
	public static Item Ak74;
	
	public static Potion JustPotion;

	@SidedProxy(clientSide = "ru.winside.testmod.proxies.ClientProxy",
			serverSide = "ru.winside.testmod.proxies.CommonProxy")
	public static CommonProxy proxy;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		CommonProxy.init();
	    Potion[] potionTypes = null;

	    for (Field f : Potion.class.getDeclaredFields()) {
	        f.setAccessible(true);
	        try {
	            if (f.getName().equals("potionTypes") || f.getName().equals("field_76425_a")) {
	                Field modfield = Field.class.getDeclaredField("modifiers");
	                modfield.setAccessible(true);
	                modfield.setInt(f, f.getModifiers() & ~Modifier.FINAL);

	                potionTypes = (Potion[])f.get(null);
	                final Potion[] newPotionTypes = new Potion[256];
	                System.arraycopy(potionTypes, 0, newPotionTypes, 0, potionTypes.length);
	                f.set(null, newPotionTypes);
	            }
	        } catch (Exception e) {
	            System.err.println("Severe error, please report this to the mod author:");
	            System.err.println(e);
	        }
	    }

	    MinecraftForge.EVENT_BUS.register(new TestModEventHooks());
	    MinecraftForge.EVENT_BUS.register(new ArmRotation());
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event) {
		
		justItem = new JustItem();
		GameRegistry.registerItem(justItem, "justItem");
		
		Ak74 = new Ak74().setTextureName(MODID + ":ak74i");
		GameRegistry.registerItem(Ak74, "ak74");
		
		JustPotion = (new TestModPotion(40, false, 0)).setIconIndex(0, 0).setPotionName("Suka Bleat'");
		
		ClientProxy.init();
	}
}

package hirosuke;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;

@Mod(modid=YukkuriManju.modid, name = YukkuriManju.name, version = YukkuriManju.version)
public class YukkuriManju {
    public static final String modid = "yukkurimanju";
    public static final String name = "Yukkuri Manju";
    public static final String version = "1.2";

    public static Item itemReimu;
    public static Item itemMarisa;

    @Mod.EventHandler
    public void perInit(FMLPreInitializationEvent event) {
        itemReimu = new ItemFood(7, 5.0f, true)
                .setCreativeTab(CreativeTabs.tabFood)
                .setTextureName("yukkurimanju:yukkurireimu")
                .setUnlocalizedName("yukkurireimu");
        itemMarisa = new ItemFood(10, 10.0f, true)
                .setCreativeTab(CreativeTabs.tabFood)
                .setTextureName("yukkurimanju:yukkurimarisa")
                .setUnlocalizedName("yukkurimarisa");

        GameRegistry.registerItem(itemReimu, "yukkurireimu");
        GameRegistry.registerItem(itemMarisa, "yukkurimarisa");
        LanguageRegistry.addName(itemReimu, "Yukkuri Reimu");
        LanguageRegistry.addName(itemMarisa, "Yukkuri Marisa");
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        GameRegistry.addRecipe(new ItemStack(itemReimu), "ABA", "BAB", "ABA", 'A', Items.apple, 'B', Items.beef);
        GameRegistry.addSmelting(new ItemStack(itemReimu), new ItemStack(itemMarisa), 0);
    }
}

package techreborn.init;

import java.security.InvalidParameterException;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.ArrayUtils;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;
import reborncore.common.util.CraftingHelper;
import reborncore.common.util.OreUtil;
import techreborn.Core;
import techreborn.api.ScrapboxList;
import techreborn.api.TechRebornAPI;
import techreborn.api.reactor.FusionReactorRecipe;
import techreborn.api.reactor.FusionReactorRecipeHelper;
import techreborn.api.recipe.RecipeHandler;
import techreborn.api.recipe.RecyclerRecipe;
import techreborn.api.recipe.ScrapboxRecipe;
import techreborn.api.recipe.machines.AlloySmelterRecipe;
import techreborn.api.recipe.machines.BlastFurnaceRecipe;
import techreborn.api.recipe.machines.CentrifugeRecipe;
import techreborn.api.recipe.machines.ChemicalReactorRecipe;
import techreborn.api.recipe.machines.CompressorRecipe;
import techreborn.api.recipe.machines.ExtractorRecipe;
import techreborn.api.recipe.machines.GrinderRecipe;
import techreborn.api.recipe.machines.ImplosionCompressorRecipe;
import techreborn.api.recipe.machines.IndustrialElectrolyzerRecipe;
import techreborn.api.recipe.machines.IndustrialGrinderRecipe;
import techreborn.api.recipe.machines.IndustrialSawmillRecipe;
import techreborn.api.recipe.machines.PlateCuttingMachineRecipe;
import techreborn.api.recipe.machines.VacuumFreezerRecipe;
import techreborn.blocks.BlockMachineFrame;
import techreborn.blocks.BlockOre;
import techreborn.blocks.BlockOre2;
import techreborn.blocks.BlockStorage;
import techreborn.blocks.BlockStorage2;
import techreborn.config.ConfigTechReborn;
import techreborn.items.ItemCells;
import techreborn.items.ItemDusts;
import techreborn.items.ItemDustsSmall;
import techreborn.items.ItemGems;
import techreborn.items.ItemIngots;
import techreborn.items.ItemNuggets;
import techreborn.items.ItemParts;
import techreborn.items.ItemPlates;
import techreborn.items.ItemUpgrades;
import techreborn.parts.ItemStandaloneCables;
import techreborn.utils.RecipeUtils;
import techreborn.utils.StackWIPHandler;

public class ModRecipes {
	public static ConfigTechReborn config;
	public static ItemStack hammerStack = new ItemStack(ModItems.hammer, 1, OreDictionary.WILDCARD_VALUE);
	public static ItemStack batteryStack = new ItemStack(ModItems.reBattery, 1, OreDictionary.WILDCARD_VALUE);
	public static ItemStack crystalStack = new ItemStack(ModItems.energyCrystal, 1, OreDictionary.WILDCARD_VALUE);
	public static ItemStack lapcrystalStack = new ItemStack(ModItems.lapotronCrystal, 1, OreDictionary.WILDCARD_VALUE);
	public static ItemStack dyes = new ItemStack(Items.dye, 1, OreDictionary.WILDCARD_VALUE);
	public static Item hammer = ModItems.hammer;

	public static void init() {
		addShapelessRecipes();
		addGeneralShapedRecipes();
		addMachineRecipes();

		addSmeltingRecipes();
		addUUrecipes();

		addAlloySmelterRecipes();
		addPlateCuttingMachineRecipes();
		addIndustrialCentrifugeRecipes();
		addChemicalReactorRecipes();
		addIndustrialElectrolyzerRecipes();

		addIndustrialSawmillRecipes();
		addBlastFurnaceRecipes();
		addIndustrialGrinderRecipes();
		addImplosionCompressorRecipes();
		addReactorRecipes();
		addIc2Recipes();
		addGrinderRecipes();
		// addHammerRecipes();
		addIc2ReplacementReicpes();
		addExtractorRecipes();
		addCompressorRecipes();
		addWireRecipes();
		addScrapBoxloot();
	}

	static void addScrapBoxloot() {
		ScrapboxList.addItemStackToList(new ItemStack(Items.diamond));
		ScrapboxList.addItemStackToList(new ItemStack(Items.stick));
		ScrapboxList.addItemStackToList(new ItemStack(Items.coal));
		ScrapboxList.addItemStackToList(new ItemStack(Items.apple));
		ScrapboxList.addItemStackToList(new ItemStack(Items.baked_potato));
		ScrapboxList.addItemStackToList(new ItemStack(Items.blaze_powder));
		ScrapboxList.addItemStackToList(new ItemStack(Items.wheat));
		ScrapboxList.addItemStackToList(new ItemStack(Items.carrot));
		ScrapboxList.addItemStackToList(new ItemStack(Items.boat));
		ScrapboxList.addItemStackToList(new ItemStack(Items.acacia_boat));
		ScrapboxList.addItemStackToList(new ItemStack(Items.birch_boat));
		ScrapboxList.addItemStackToList(new ItemStack(Items.dark_oak_boat));
		ScrapboxList.addItemStackToList(new ItemStack(Items.jungle_boat));
		ScrapboxList.addItemStackToList(new ItemStack(Items.spruce_boat));
		ScrapboxList.addItemStackToList(new ItemStack(Items.blaze_rod));
		ScrapboxList.addItemStackToList(new ItemStack(Items.compass));
		ScrapboxList.addItemStackToList(new ItemStack(Items.map));
		ScrapboxList.addItemStackToList(new ItemStack(Items.leather_leggings));
		ScrapboxList.addItemStackToList(new ItemStack(Items.bow));
		ScrapboxList.addItemStackToList(new ItemStack(Items.cooked_chicken));
		ScrapboxList.addItemStackToList(new ItemStack(Items.cake));
		ScrapboxList.addItemStackToList(new ItemStack(Items.acacia_door));
		ScrapboxList.addItemStackToList(new ItemStack(Items.dark_oak_door));
		ScrapboxList.addItemStackToList(new ItemStack(Items.birch_door));
		ScrapboxList.addItemStackToList(new ItemStack(Items.jungle_door));
		ScrapboxList.addItemStackToList(new ItemStack(Items.oak_door));
		ScrapboxList.addItemStackToList(new ItemStack(Items.spruce_door));
		ScrapboxList.addItemStackToList(new ItemStack(Items.wooden_axe));
		ScrapboxList.addItemStackToList(new ItemStack(Items.wooden_hoe));
		ScrapboxList.addItemStackToList(new ItemStack(Items.wooden_pickaxe));
		ScrapboxList.addItemStackToList(new ItemStack(Items.wooden_shovel));
		ScrapboxList.addItemStackToList(new ItemStack(Items.wooden_sword));
		ScrapboxList.addItemStackToList(new ItemStack(Items.bed));
		ScrapboxList.addItemStackToList(new ItemStack(Items.skull, 1, 0));
		ScrapboxList.addItemStackToList(new ItemStack(Items.skull, 1, 2));
		ScrapboxList.addItemStackToList(new ItemStack(Items.skull, 1, 4));
		for (int i = 0; i < StackWIPHandler.devHeads.size(); i++)
			ScrapboxList.addItemStackToList(StackWIPHandler.devHeads.get(i));
		ScrapboxList.addItemStackToList(new ItemStack(Items.dye, 1, 3));
		ScrapboxList.addItemStackToList(new ItemStack(Items.glowstone_dust));
		ScrapboxList.addItemStackToList(new ItemStack(Items.string));
		ScrapboxList.addItemStackToList(new ItemStack(Items.minecart));
		ScrapboxList.addItemStackToList(new ItemStack(Items.chest_minecart));
		ScrapboxList.addItemStackToList(new ItemStack(Items.hopper_minecart));
		ScrapboxList.addItemStackToList(new ItemStack(Items.prismarine_shard));
		ScrapboxList.addItemStackToList(new ItemStack(Items.shears));
		ScrapboxList.addItemStackToList(new ItemStack(Items.experience_bottle));
		ScrapboxList.addItemStackToList(new ItemStack(Items.bone));
		ScrapboxList.addItemStackToList(new ItemStack(Items.bowl));
		ScrapboxList.addItemStackToList(new ItemStack(Items.brick));
		ScrapboxList.addItemStackToList(new ItemStack(Items.fishing_rod));
		ScrapboxList.addItemStackToList(new ItemStack(Items.book));
		ScrapboxList.addItemStackToList(new ItemStack(Items.paper));
		ScrapboxList.addItemStackToList(new ItemStack(Items.sugar));
		ScrapboxList.addItemStackToList(new ItemStack(Items.reeds));
		ScrapboxList.addItemStackToList(new ItemStack(Items.spider_eye));
		ScrapboxList.addItemStackToList(new ItemStack(Items.slime_ball));
		ScrapboxList.addItemStackToList(new ItemStack(Items.rotten_flesh));
		ScrapboxList.addItemStackToList(new ItemStack(Items.sign));
		ScrapboxList.addItemStackToList(new ItemStack(Items.writable_book));
		ScrapboxList.addItemStackToList(new ItemStack(Items.cooked_beef));
		ScrapboxList.addItemStackToList(new ItemStack(Items.name_tag));
		ScrapboxList.addItemStackToList(new ItemStack(Items.saddle));
		ScrapboxList.addItemStackToList(new ItemStack(Items.redstone));
		ScrapboxList.addItemStackToList(new ItemStack(Items.gunpowder));
		ScrapboxList.addItemStackToList(new ItemStack(Items.rabbit_hide));
		ScrapboxList.addItemStackToList(new ItemStack(Items.rabbit_foot));
		ScrapboxList.addItemStackToList(new ItemStack(Items.apple));
		ScrapboxList.addItemStackToList(new ItemStack(Items.golden_apple));
		ScrapboxList.addItemStackToList(new ItemStack(Items.gold_nugget));

		ScrapboxList.addItemStackToList(ItemCells.getCellByName("empty"));
		ScrapboxList.addItemStackToList(ItemCells.getCellByName("water"));
		ScrapboxList.addItemStackToList(ItemParts.getPartByName("scrap"));
		ScrapboxList.addItemStackToList(ItemParts.getPartByName("rubber"));

		ScrapboxList.addItemStackToList(new ItemStack(Blocks.trapdoor));
		ScrapboxList.addItemStackToList(new ItemStack(Blocks.stone_button));
		ScrapboxList.addItemStackToList(new ItemStack(Blocks.wooden_button));
		ScrapboxList.addItemStackToList(new ItemStack(Blocks.acacia_fence));
		ScrapboxList.addItemStackToList(new ItemStack(Blocks.acacia_fence_gate));
		ScrapboxList.addItemStackToList(new ItemStack(Blocks.birch_fence));
		ScrapboxList.addItemStackToList(new ItemStack(Blocks.birch_fence_gate));
		ScrapboxList.addItemStackToList(new ItemStack(Blocks.dark_oak_fence));
		ScrapboxList.addItemStackToList(new ItemStack(Blocks.dark_oak_fence_gate));
		ScrapboxList.addItemStackToList(new ItemStack(Blocks.jungle_fence));
		ScrapboxList.addItemStackToList(new ItemStack(Blocks.jungle_fence_gate));
		ScrapboxList.addItemStackToList(new ItemStack(Blocks.nether_brick_fence));
		ScrapboxList.addItemStackToList(new ItemStack(Blocks.oak_fence));
		ScrapboxList.addItemStackToList(new ItemStack(Blocks.oak_fence_gate));
		ScrapboxList.addItemStackToList(new ItemStack(Blocks.spruce_fence));
		ScrapboxList.addItemStackToList(new ItemStack(Blocks.spruce_fence_gate));
		ScrapboxList.addItemStackToList(new ItemStack(Blocks.brick_block));
		ScrapboxList.addItemStackToList(new ItemStack(Blocks.crafting_table));
		ScrapboxList.addItemStackToList(new ItemStack(Blocks.pumpkin));
		ScrapboxList.addItemStackToList(new ItemStack(Blocks.netherrack));
		ScrapboxList.addItemStackToList(new ItemStack(Blocks.grass));
		ScrapboxList.addItemStackToList(new ItemStack(Blocks.dirt, 1, 0));
		ScrapboxList.addItemStackToList(new ItemStack(Blocks.dirt, 1, 1));
		ScrapboxList.addItemStackToList(new ItemStack(Blocks.sand, 1, 0));
		ScrapboxList.addItemStackToList(new ItemStack(Blocks.sand, 1, 1));
		ScrapboxList.addItemStackToList(new ItemStack(Blocks.glowstone));
		ScrapboxList.addItemStackToList(new ItemStack(Blocks.gravel));
		ScrapboxList.addItemStackToList(new ItemStack(Blocks.hardened_clay));
		ScrapboxList.addItemStackToList(new ItemStack(Blocks.glass));
		ScrapboxList.addItemStackToList(new ItemStack(Blocks.glass_pane));
		ScrapboxList.addItemStackToList(new ItemStack(Blocks.cactus));
		ScrapboxList.addItemStackToList(new ItemStack(Blocks.tallgrass, 1, 0));
		ScrapboxList.addItemStackToList(new ItemStack(Blocks.tallgrass, 1, 1));
		ScrapboxList.addItemStackToList(new ItemStack(Blocks.deadbush));
		ScrapboxList.addItemStackToList(new ItemStack(Blocks.chest));
		ScrapboxList.addItemStackToList(new ItemStack(Blocks.tnt));
		ScrapboxList.addItemStackToList(new ItemStack(Blocks.rail));
		ScrapboxList.addItemStackToList(new ItemStack(Blocks.detector_rail));
		ScrapboxList.addItemStackToList(new ItemStack(Blocks.golden_rail));
		ScrapboxList.addItemStackToList(new ItemStack(Blocks.activator_rail));
		ScrapboxList.addItemStackToList(new ItemStack(Blocks.yellow_flower));
		ScrapboxList.addItemStackToList(new ItemStack(Blocks.red_flower, 1, 0));
		ScrapboxList.addItemStackToList(new ItemStack(Blocks.red_flower, 1, 1));
		ScrapboxList.addItemStackToList(new ItemStack(Blocks.red_flower, 1, 2));
		ScrapboxList.addItemStackToList(new ItemStack(Blocks.red_flower, 1, 3));
		ScrapboxList.addItemStackToList(new ItemStack(Blocks.red_flower, 1, 4));
		ScrapboxList.addItemStackToList(new ItemStack(Blocks.red_flower, 1, 5));
		ScrapboxList.addItemStackToList(new ItemStack(Blocks.red_flower, 1, 6));
		ScrapboxList.addItemStackToList(new ItemStack(Blocks.red_flower, 1, 7));
		ScrapboxList.addItemStackToList(new ItemStack(Blocks.red_flower, 1, 8));
		ScrapboxList.addItemStackToList(new ItemStack(Blocks.brown_mushroom));
		ScrapboxList.addItemStackToList(new ItemStack(Blocks.red_mushroom));
		ScrapboxList.addItemStackToList(new ItemStack(Blocks.brown_mushroom_block));
		ScrapboxList.addItemStackToList(new ItemStack(Blocks.red_mushroom_block));
		ScrapboxList.addItemStackToList(new ItemStack(Blocks.sapling, 1, 0));
		ScrapboxList.addItemStackToList(new ItemStack(Blocks.sapling, 1, 1));
		ScrapboxList.addItemStackToList(new ItemStack(Blocks.sapling, 1, 2));
		ScrapboxList.addItemStackToList(new ItemStack(Blocks.sapling, 1, 3));
		ScrapboxList.addItemStackToList(new ItemStack(Blocks.sapling, 1, 4));
		ScrapboxList.addItemStackToList(new ItemStack(Blocks.sapling, 1, 5));
		ScrapboxList.addItemStackToList(new ItemStack(Blocks.leaves, 1, 0));
		ScrapboxList.addItemStackToList(new ItemStack(Blocks.leaves, 1, 1));
		ScrapboxList.addItemStackToList(new ItemStack(Blocks.leaves, 1, 2));
		ScrapboxList.addItemStackToList(new ItemStack(Blocks.leaves, 1, 3));
		ScrapboxList.addItemStackToList(new ItemStack(Blocks.leaves2, 1, 0));
		ScrapboxList.addItemStackToList(new ItemStack(Blocks.leaves2, 1, 1));

		ScrapboxList.addItemStackToList(new ItemStack(ModBlocks.rubberSapling));

		for (String i : ItemDusts.types)
			ScrapboxList.addItemStackToList(ItemDusts.getDustByName(i));

		for (String i : ItemNuggets.types)
			ScrapboxList.addItemStackToList(ItemNuggets.getNuggetByName(i));

		for (String i : ItemGems.types)
			ScrapboxList.addItemStackToList(ItemGems.getGemByName(i));

		registerDyable(Blocks.carpet);
		registerDyable(Blocks.stained_glass);
		registerDyable(Blocks.stained_glass_pane);
		registerDyable(Blocks.stained_hardened_clay);

		for (int i = 0; i < ScrapboxList.stacks.size(); i++) {
			RecipeHandler.addRecipe(new ScrapboxRecipe(ScrapboxList.stacks.get(i)));
		}

		// just for jei
		// TODO find a way to get all ItemStacks in mc
		for (int i = 0; i < ScrapboxList.stacks.size(); i++) {
			RecipeHandler.addRecipe(new RecyclerRecipe(ScrapboxList.stacks.get(i)));
		}
	}

	static void registerMetadataItem(ItemStack item) {
		for (int i = 0; i < item.getItem().getMaxDamage(); i++) {
			ScrapboxList.addItemStackToList(new ItemStack(item.getItem(), 1, i));
		}
	}

	static void registerDyable(Block block) {
		for (int i = 0; i < 16; i++)
			ScrapboxList.stacks.add(new ItemStack(block, 1, i));
	}

	static void addWireRecipes() {
		CraftingHelper.addShapedOreRecipe(ItemStandaloneCables.getCableByName("copper", 6), "CCC", 'C', "ingotCopper");
		CraftingHelper.addShapedOreRecipe(ItemStandaloneCables.getCableByName("tin", 9), "CCC", 'C', "ingotTin");
		CraftingHelper.addShapedOreRecipe(ItemStandaloneCables.getCableByName("gold", 12), "CCC", 'C', "ingotGold");
		CraftingHelper.addShapedOreRecipe(ItemStandaloneCables.getCableByName("hv", 12), "CCC", 'C',
				"ingotRefinedIron");

		CraftingHelper.addShapedOreRecipe(ItemStandaloneCables.getCableByName("glassfiber", 4), "GGG", "SDS", "GGG",
				'G', "blockGlass", 'S', "dustRedstone", 'D', "diamondTR");

		CraftingHelper.addShapedOreRecipe(ItemStandaloneCables.getCableByName("glassfiber", 6), "GGG", "SDS", "GGG",
				'G', "blockGlass", 'S', "dustRedstone", 'D', "gemRuby");

		CraftingHelper.addShapedOreRecipe(ItemStandaloneCables.getCableByName("glassfiber", 6), "GGG", "SDS", "GGG",
				'G', "blockGlass", 'S', "ingotSilver", 'D', "diamondTR");
		CraftingHelper.addShapedOreRecipe(ItemStandaloneCables.getCableByName("glassfiber", 8), "GGG", "SDS", "GGG",
				'G', "blockGlass", 'S', "ingotElectrum", 'D', "diamondTR");

		CraftingHelper.addShapelessOreRecipe(ItemStandaloneCables.getCableByName("insulatedcopper"), "materialRubber",
				ItemStandaloneCables.getCableByName("copper"));
		CraftingHelper.addShapelessOreRecipe(ItemStandaloneCables.getCableByName("insulatedgold"), "materialRubber",
				"materialRubber", ItemStandaloneCables.getCableByName("gold"));
		CraftingHelper.addShapelessOreRecipe(ItemStandaloneCables.getCableByName("insulatedhv"), "materialRubber",
				"materialRubber", ItemStandaloneCables.getCableByName("hv"));

		CraftingHelper.addShapedOreRecipe(ItemStandaloneCables.getCableByName("insulatedcopper", 6), "RRR", "III",
				"RRR", 'R', "materialRubber", 'I', "ingotCopper");
		CraftingHelper.addShapedOreRecipe(ItemStandaloneCables.getCableByName("insulatedgold", 4), "RRR", "RIR", "RRR",
				'R', "materialRubber", 'I', "ingotGold");
		CraftingHelper.addShapedOreRecipe(ItemStandaloneCables.getCableByName("insulatedhv", 4), "RRR", "RIR", "RRR",
				'R', "materialRubber", 'I', "ingotRefinedIron");
	}

	private static void addCompressorRecipes() {
		RecipeHandler.addRecipe(new CompressorRecipe(ItemParts.getPartByName("mixedmetalingot"),
				ItemParts.getPartByName("advancedAlloy"), 400, 20));
		RecipeHandler.addRecipe(new CompressorRecipe(ItemParts.getPartByName("carbonmesh"),
				ItemPlates.getPlateByName("carbon"), 400, 20));

		RecipeHandler.addRecipe(
				new CompressorRecipe(new ItemStack(Items.iron_ingot), ItemPlates.getPlateByName("iron"), 400, 20));
		RecipeHandler.addRecipe(new CompressorRecipe(ItemIngots.getIngotByName("copper"),
				ItemPlates.getPlateByName("copper"), 400, 20));
		RecipeHandler.addRecipe(
				new CompressorRecipe(ItemIngots.getIngotByName("tin"), ItemPlates.getPlateByName("tin"), 400, 20));
		RecipeHandler.addRecipe(new CompressorRecipe(ItemIngots.getIngotByName("aluminum"),
				ItemPlates.getPlateByName("aluminum"), 400, 20));
		RecipeHandler.addRecipe(
				new CompressorRecipe(ItemIngots.getIngotByName("brass"), ItemPlates.getPlateByName("brass"), 400, 20));
		RecipeHandler.addRecipe(new CompressorRecipe(ItemIngots.getIngotByName("bronze"),
				ItemPlates.getPlateByName("bronze"), 400, 20));
		RecipeHandler.addRecipe(
				new CompressorRecipe(ItemIngots.getIngotByName("lead"), ItemPlates.getPlateByName("lead"), 400, 20));
		RecipeHandler.addRecipe(new CompressorRecipe(ItemIngots.getIngotByName("silver"),
				ItemPlates.getPlateByName("silver"), 400, 20));
	}

	static void addExtractorRecipes() {
		RecipeHandler.addRecipe(new ExtractorRecipe(ItemParts.getPartByName("rubberSap"),
				ItemParts.getPartByName("rubber", 3), 400, 20));
		RecipeHandler.addRecipe(
				new ExtractorRecipe(new ItemStack(ModBlocks.rubberLog), ItemParts.getPartByName("rubber"), 400, 20));
	}

	static void addIc2ReplacementReicpes() {
		// TODO: Replace item pump with block
		CraftingHelper.addShapedOreRecipe(ItemParts.getPartByName("pump"), "CEC", "CMC", "PTP", 'C',
				ItemCells.getCellByName("empty"), 'T', new ItemStack(ModItems.treeTap), 'M', "machineBlockBasic", 'P',
				new ItemStack(Blocks.iron_bars), 'E', "circuitBasic");

		// TODO: Replace item teleporter with block
		CraftingHelper.addShapedOreRecipe(ItemParts.getPartByName("teleporter"), "CTC", "WMW", "CDC", 'C',
				"circuitAdvanced", 'T', new ItemStack(ModItems.frequencyTransmitter), 'M', "machineBlockAdvanced", 'W',
				ItemStandaloneCables.getCableByName("glassfiber"), 'D', "gemDiamond", 'E', "circuitBasic");
	}

	static void addGrinderRecipes() {
		// Vanilla
		RecipeHandler.addRecipe(
				new GrinderRecipe(new ItemStack(Blocks.iron_ore), ItemDusts.getDustByName("iron", 2), 100, 20));
		RecipeHandler.addRecipe(
				new GrinderRecipe(new ItemStack(Blocks.gold_ore), ItemDusts.getDustByName("gold", 2), 100, 20));
		RecipeHandler.addRecipe(new GrinderRecipe(new ItemStack(Items.coal), ItemDusts.getDustByName("coal"), 100, 20));
		RecipeHandler
				.addRecipe(new GrinderRecipe(new ItemStack(Blocks.coal_ore), new ItemStack(Items.coal, 2), 100, 20));
		RecipeHandler.addRecipe(new GrinderRecipe(new ItemStack(Items.bone), new ItemStack(Items.dye, 6, 15), 100, 20));
		RecipeHandler
				.addRecipe(new GrinderRecipe(new ItemStack(Blocks.cobblestone), new ItemStack(Blocks.sand), 100, 20));
		RecipeHandler.addRecipe(new GrinderRecipe(new ItemStack(Blocks.gravel), new ItemStack(Items.flint), 100, 20));

		// TechReborn
		RecipeHandler.addRecipe(
				new GrinderRecipe(BlockOre2.getOreByName("copper"), ItemDusts.getDustByName("copper", 2), 100, 20));
		RecipeHandler.addRecipe(
				new GrinderRecipe(BlockOre2.getOreByName("tin"), ItemDusts.getDustByName("tin", 2), 100, 20));
		RecipeHandler.addRecipe(
				new GrinderRecipe(BlockOre.getOreByName("Lead"), ItemDusts.getDustByName("lead", 2), 100, 20));
		RecipeHandler.addRecipe(
				new GrinderRecipe(BlockOre.getOreByName("Silver"), ItemDusts.getDustByName("silver", 2), 100, 20));
		RecipeHandler
				.addRecipe(new GrinderRecipe(ItemGems.getGemByName("ruby"), ItemDusts.getDustByName("ruby"), 100, 20));
	}

	// static void addHammerRecipes()
	// {
	// CraftingHelper.addShapedOreRecipe(new ItemStack(ModItems.hammer), "III",
	// "ISI", " S ", 'S', Items.stick, 'I',
	// "ingotIron");
	//
	// CraftingHelper.addShapelessOreRecipe(ItemPlates.getPlateByName("iron",
	// 1), hammerStack, "ingotIron");
	// CraftingHelper.addShapelessOreRecipe(ItemPlates.getPlateByName("copper",
	// 1), hammerStack, "ingotCopper");
	// CraftingHelper.addShapelessOreRecipe(ItemPlates.getPlateByName("tin", 1),
	// hammerStack, "ingotTin");
	// CraftingHelper.addShapelessOreRecipe(ItemPlates.getPlateByName("bronze",
	// 1), hammerStack, "ingotBronze");
	// CraftingHelper.addShapelessOreRecipe(ItemPlates.getPlateByName("brass",
	// 1), hammerStack, "ingotBrass");
	// CraftingHelper.addShapelessOreRecipe(ItemPlates.getPlateByName("steel",
	// 1), hammerStack, "ingotSteel");
	//
	// hammer.setContainerItem(hammer);
	// }

	static void addReactorRecipes() {
		FusionReactorRecipeHelper.registerRecipe(new FusionReactorRecipe(ItemCells.getCellByName("tritium"),
				ItemCells.getCellByName("deuterium"), ItemCells.getCellByName("helium"), 40000000, 32768, 1024));
		FusionReactorRecipeHelper.registerRecipe(new FusionReactorRecipe(ItemCells.getCellByName("tritium"),
				ItemCells.getCellByName("deuterium"), ItemCells.getCellByName("helium3"), 60000000, 32768, 2048));
		FusionReactorRecipeHelper.registerRecipe(new FusionReactorRecipe(ItemCells.getCellByName("wolframium"),
				ItemCells.getCellByName("Berylium"), ItemDusts.getDustByName("platinum"), 80000000, -2048, 1024));
	}

	static void addGeneralShapedRecipes() {

		// Storage Blocks
		for (String name : ArrayUtils.addAll(BlockStorage.types, BlockStorage2.types)) {
			CraftingHelper.addShapedOreRecipe(BlockStorage.getStorageBlockByName(name), "AAA", "AAA", "AAA", 'A',
					"ingot" + name.substring(0, 1).toUpperCase() + name.substring(1));
		}
		CraftingHelper.addShapedOreRecipe(ItemCells.getCellByName("empty", 16, false), " T ", "T T", " T ", 'T',
				"ingotTin");

		CraftingHelper.addShapedOreRecipe(new ItemStack(ModBlocks.ironFence, 6), "   ", "RRR", "RRR", 'R',
				ItemIngots.getIngotByName("refinedIron"));

		addGemToolRecipes(new ItemStack(ModItems.rubySword), new ItemStack(ModItems.rubyPickaxe),
				new ItemStack(ModItems.rubyAxe), new ItemStack(ModItems.rubyHoe), new ItemStack(ModItems.rubySpade),
				new ItemStack(ModItems.rubyHelmet), new ItemStack(ModItems.rubyChestplate),
				new ItemStack(ModItems.rubyLeggings), new ItemStack(ModItems.rubyBoots), ItemGems.getGemByName("ruby"));

		addGemToolRecipes(new ItemStack(ModItems.sapphireSword), new ItemStack(ModItems.sapphirePickaxe),
				new ItemStack(ModItems.sapphireAxe), new ItemStack(ModItems.sapphireHoe),
				new ItemStack(ModItems.sapphireSpade), new ItemStack(ModItems.sapphireHelmet),
				new ItemStack(ModItems.sapphireChestplate), new ItemStack(ModItems.sapphireLeggings),
				new ItemStack(ModItems.sapphireBoots), ItemGems.getGemByName("sapphire"));

		addGemToolRecipes(new ItemStack(ModItems.peridotSword), new ItemStack(ModItems.peridotPickaxe),
				new ItemStack(ModItems.peridotAxe), new ItemStack(ModItems.peridotHoe),
				new ItemStack(ModItems.peridotSpade), new ItemStack(ModItems.peridotHelmet),
				new ItemStack(ModItems.peridotChestplate), new ItemStack(ModItems.peridotLeggings),
				new ItemStack(ModItems.peridotBoots), ItemGems.getGemByName("peridot"));

		addGemToolRecipes(new ItemStack(ModItems.bronzeSword), new ItemStack(ModItems.bronzePickaxe),
				new ItemStack(ModItems.bronzeAxe), new ItemStack(ModItems.bronzeHoe),
				new ItemStack(ModItems.bronzeSpade), new ItemStack(ModItems.bronzeHelmet),
				new ItemStack(ModItems.bronzeChestplate), new ItemStack(ModItems.bronzeLeggings),
				new ItemStack(ModItems.bronzeBoots), ItemIngots.getIngotByName("bronze"));

		CraftingHelper.addShapedOreRecipe(new ItemStack(ModItems.ironChainsaw), " SS", "SCS", "BS ", 'S', "ingotSteel",
				'B', TechRebornAPI.recipeCompact.getItem("reBattery"), 'C',
				TechRebornAPI.recipeCompact.getItem("electronicCircuit"));

		CraftingHelper.addShapedOreRecipe(new ItemStack(ModItems.diamondChainsaw), " SS", "SBS", "CS ", 'S',
				"ingotSteel", 'B', ModItems.ironChainsaw, 'C',
				TechRebornAPI.recipeCompact.getItem("electronicCircuit"));

		CraftingHelper.addShapelessOreRecipe(ItemParts.getPartByName("carbonfiber"), ItemDusts.getDustByName("coal"),
				ItemDusts.getDustByName("coal"), ItemDusts.getDustByName("coal"), ItemDusts.getDustByName("coal"));

		CraftingHelper.addShapelessOreRecipe(ItemParts.getPartByName("carbonfiber"), ItemCells.getCellByName("carbon"),
				ItemCells.getCellByName("carbon"), ItemCells.getCellByName("carbon"), ItemCells.getCellByName("carbon"),
				ItemCells.getCellByName("carbon"), ItemCells.getCellByName("carbon"), ItemCells.getCellByName("carbon"),
				ItemCells.getCellByName("carbon"), ItemCells.getCellByName("carbon"));

		CraftingHelper.addShapelessOreRecipe(ItemParts.getPartByName("carbonmesh"),
				ItemParts.getPartByName("carbonfiber"), ItemParts.getPartByName("carbonfiber"));

		CraftingHelper.addShapedOreRecipe(ItemParts.getPartByName("computerMonitor"), "ADA", "DGD", "ADA", 'D', dyes,
				'A', "ingotAluminum", 'G', Blocks.glass_pane);

		CraftingHelper.addShapedOreRecipe(new ItemStack(ModBlocks.reinforcedglass, 7), "GAG", "GGG", "GAG", 'A',
				ItemParts.getPartByName("advancedAlloy"), 'G', Blocks.glass);

		CraftingHelper.addShapedOreRecipe(new ItemStack(ModBlocks.windMill, 2), "IXI", "XGX", "IXI", 'I', "ingotIron",
				'G', ModBlocks.Generator);

		CraftingHelper.addShapedOreRecipe(new ItemStack(ModBlocks.waterMill), "SWS", "WGW", "SWS", 'S', Items.stick,
				'W', "plankWood", 'G', ModBlocks.Generator);

		CraftingHelper.addShapedOreRecipe(new ItemStack(ModBlocks.hvt), "XHX", "XMX", "XHX", 'M', ModBlocks.mvt, 'H',
				ItemStandaloneCables.getCableByName("insulatedhv"));

		CraftingHelper.addShapedOreRecipe(new ItemStack(ModBlocks.mvt), "XGX", "XMX", "XGX", 'M',
				BlockMachineFrame.getFrameByName("machine", 1), 'G',
				ItemStandaloneCables.getCableByName("insulatedgold"));

		CraftingHelper.addShapedOreRecipe(new ItemStack(ModBlocks.lvt), "PWP", "CCC", "PPP", 'P', "plankWood", 'C',
				"ingotCopper", 'W', ItemStandaloneCables.getCableByName("insulatedcopper"));

		CraftingHelper.addShapedOreRecipe(new ItemStack(ModBlocks.MachineCasing, 4, 0), "RRR", "CAC", "RRR", 'R',
				ItemIngots.getIngotByName("refinedIron"), 'C', ItemParts.getPartByName("electronicCircuit"), 'A',
				BlockMachineFrame.getFrameByName("machine", 1));

		CraftingHelper.addShapedOreRecipe(new ItemStack(ModBlocks.MachineCasing, 4, 1), "RRR", "CAC", "RRR", 'R',
				"ingotSteel", 'C', ItemParts.getPartByName("advancedCircuit"), 'A',
				BlockMachineFrame.getFrameByName("advancedMachine", 1));

		CraftingHelper.addShapedOreRecipe(ItemParts.getPartByName("dataOrb"), "DDD", "DID", "DDD", 'D',
				ItemParts.getPartByName("dataStorageCircuit"), 'I', ItemParts.getPartByName("dataControlCircuit"));

		CraftingHelper.addShapedOreRecipe(ItemParts.getPartByName("dataControlCircuit", 4), "CDC", "DID", "CDC", 'I',
				ItemPlates.getPlateByName("iridium"), 'D', ItemParts.getPartByName("dataStorageCircuit"), 'C',
				ItemParts.getPartByName("advancedCircuit"));

		CraftingHelper.addShapedOreRecipe(new ItemStack(ModBlocks.thermalGenerator), "III", "IRI", "CGC", 'I',
				ItemIngots.getIngotByName("invar"), 'R', ModBlocks.reinforcedglass, 'G', ModBlocks.Generator, 'C',
				ItemParts.getPartByName("electronicCircuit"));

		CraftingHelper.addShapedOreRecipe(new ItemStack(ModBlocks.recycler), "XEX", "DCD", "GDG", 'D', Blocks.dirt, 'C',
				ModBlocks.Compressor, 'G', Items.glowstone_dust, 'E', ItemParts.getPartByName("electronicCircuit"));

		CraftingHelper.addShapedOreRecipe(new ItemStack(ModBlocks.batBox), "WCW", "BBB", "WWW", 'W', "plankWood", 'B',
				batteryStack, 'C', ItemStandaloneCables.getCableByName("insulatedcopper"));

		CraftingHelper.addShapedOreRecipe(new ItemStack(ModBlocks.mfe), "GEG", "EME", "GEG", 'M',
				BlockMachineFrame.getFrameByName("machine", 1), 'E', crystalStack, 'G',
				ItemStandaloneCables.getCableByName("insulatedgold"));

		CraftingHelper.addShapedOreRecipe(new ItemStack(ModBlocks.mfsu), "LAL", "LML", "LOL", 'A',
				ItemParts.getPartByName("advancedCircuit"), 'L', lapcrystalStack, 'M', new ItemStack(ModBlocks.mfe),
				'O', BlockMachineFrame.getFrameByName("advancedMachine", 1));

		CraftingHelper.addShapedOreRecipe(new ItemStack(ModBlocks.IndustrialElectrolyzer), "RER", "CEC", "RER", 'R',
				ItemIngots.getIngotByName("refinediron"), 'E', new ItemStack(ModBlocks.Extractor), 'C',
				ItemParts.getPartByName("advancedCircuit"));

		// Mixed Metal Ingot Recipes :P

		CraftingHelper.addShapedOreRecipe(ItemParts.getPartByName("mixedmetalingot", 2), "RRR", "BBB", "TTT", 'R',
				"ingotRefinedIron", 'B', "ingotBronze", 'T', "ingotTin");

		CraftingHelper.addShapedOreRecipe(ItemParts.getPartByName("mixedmetalingot", 2), "RRR", "BBB", "TTT", 'R',
				"ingotRefinedIron", 'B', "ingotBronze", 'T', "ingotZinc");

		CraftingHelper.addShapedOreRecipe(ItemParts.getPartByName("mixedmetalingot", 2), "RRR", "BBB", "TTT", 'R',
				"ingotRefinedIron", 'B', "ingotBrass", 'T', "ingotTin");

		CraftingHelper.addShapedOreRecipe(ItemParts.getPartByName("mixedmetalingot", 2), "RRR", "BBB", "TTT", 'R',
				"ingotRefinedIron", 'B', "ingotBrass", 'T', "ingotZinc");

		CraftingHelper.addShapedOreRecipe(ItemParts.getPartByName("mixedmetalingot", 3), "RRR", "BBB", "TTT", 'R',
				"ingotNickel", 'B', "ingotBronze", 'T', "ingotTin");

		CraftingHelper.addShapedOreRecipe(ItemParts.getPartByName("mixedmetalingot", 3), "RRR", "BBB", "TTT", 'R',
				"ingotNickel", 'B', "ingotBronze", 'T', "ingotZinc");

		CraftingHelper.addShapedOreRecipe(ItemParts.getPartByName("mixedmetalingot", 3), "RRR", "BBB", "TTT", 'R',
				"ingotNickel", 'B', "ingotBrass", 'T', "ingotTin");

		CraftingHelper.addShapedOreRecipe(ItemParts.getPartByName("mixedmetalingot", 3), "RRR", "BBB", "TTT", 'R',
				"ingotNickel", 'B', "ingotBrass", 'T', "ingotZinc");

		CraftingHelper.addShapedOreRecipe(ItemParts.getPartByName("mixedmetalingot", 4), "RRR", "BBB", "TTT", 'R',
				"ingotNickel", 'B', "ingotBronze", 'T', "ingotAluminum");

		CraftingHelper.addShapedOreRecipe(ItemParts.getPartByName("mixedmetalingot", 4), "RRR", "BBB", "TTT", 'R',
				"ingotNickel", 'B', "ingotBrass", 'T', "ingotAluminum");

		CraftingHelper.addShapedOreRecipe(ItemParts.getPartByName("mixedmetalingot", 4), "RRR", "BBB", "TTT", 'R',
				"ingotInvar", 'B', "ingotBronze", 'T', "ingotTin");

		CraftingHelper.addShapedOreRecipe(ItemParts.getPartByName("mixedmetalingot", 4), "RRR", "BBB", "TTT", 'R',
				"ingotInvar", 'B', "ingotBronze", 'T', "ingotZinc");

		CraftingHelper.addShapedOreRecipe(ItemParts.getPartByName("mixedmetalingot", 4), "RRR", "BBB", "TTT", 'R',
				"ingotInvar", 'B', "ingotBrass", 'T', "ingotTin");

		CraftingHelper.addShapedOreRecipe(ItemParts.getPartByName("mixedmetalingot", 4), "RRR", "BBB", "TTT", 'R',
				"ingotInvar", 'B', "ingotBrass", 'T', "ingotZinc");

		CraftingHelper.addShapedOreRecipe(ItemParts.getPartByName("mixedmetalingot", 5), "RRR", "BBB", "TTT", 'R',
				"ingotInvar", 'B', "ingotBronze", 'T', "ingotAluminum");

		CraftingHelper.addShapedOreRecipe(ItemParts.getPartByName("mixedmetalingot", 5), "RRR", "BBB", "TTT", 'R',
				"ingotInvar", 'B', "ingotBrass", 'T', "ingotAluminum");

		CraftingHelper.addShapedOreRecipe(ItemParts.getPartByName("mixedmetalingot", 5), "RRR", "BBB", "TTT", 'R',
				"ingotTitanium", 'B', "ingotBronze", 'T', "ingotTin");

		CraftingHelper.addShapedOreRecipe(ItemParts.getPartByName("mixedmetalingot", 5), "RRR", "BBB", "TTT", 'R',
				"ingotTitanium", 'B', "ingotBronze", 'T', "ingotZinc");

		CraftingHelper.addShapedOreRecipe(ItemParts.getPartByName("mixedmetalingot", 5), "RRR", "BBB", "TTT", 'R',
				"ingotTitanium", 'B', "ingotBrass", 'T', "ingotTin");

		CraftingHelper.addShapedOreRecipe(ItemParts.getPartByName("mixedmetalingot", 5), "RRR", "BBB", "TTT", 'R',
				"ingotTitanium", 'B', "ingotBrass", 'T', "ingotZinc");

		CraftingHelper.addShapedOreRecipe(ItemParts.getPartByName("mixedmetalingot", 6), "RRR", "BBB", "TTT", 'R',
				"ingotTitanium", 'B', "ingotBronze", 'T', "ingotAluminum");

		CraftingHelper.addShapedOreRecipe(ItemParts.getPartByName("mixedmetalingot", 6), "RRR", "BBB", "TTT", 'R',
				"ingotTitanium", 'B', "ingotBrass", 'T', "ingotAluminum");

		CraftingHelper.addShapedOreRecipe(ItemParts.getPartByName("mixedmetalingot", 5), "RRR", "BBB", "TTT", 'R',
				"ingotTungsten", 'B', "ingotBronze", 'T', "ingotTin");

		CraftingHelper.addShapedOreRecipe(ItemParts.getPartByName("mixedmetalingot", 5), "RRR", "BBB", "TTT", 'R',
				"ingotTungsten", 'B', "ingotBronze", 'T', "ingotZinc");

		CraftingHelper.addShapedOreRecipe(ItemParts.getPartByName("mixedmetalingot", 5), "RRR", "BBB", "TTT", 'R',
				"ingotTungsten", 'B', "ingotBrass", 'T', "ingotTin");

		CraftingHelper.addShapedOreRecipe(ItemParts.getPartByName("mixedmetalingot", 5), "RRR", "BBB", "TTT", 'R',
				"ingotTungsten", 'B', "ingotBrass", 'T', "ingotZinc");

		CraftingHelper.addShapedOreRecipe(ItemParts.getPartByName("mixedmetalingot", 6), "RRR", "BBB", "TTT", 'R',
				"ingotTungsten", 'B', "ingotBronze", 'T', "ingotAluminum");

		CraftingHelper.addShapedOreRecipe(ItemParts.getPartByName("mixedmetalingot", 6), "RRR", "BBB", "TTT", 'R',
				"ingotTungsten", 'B', "ingotBrass", 'T', "ingotAluminum");

		CraftingHelper.addShapedOreRecipe(ItemParts.getPartByName("mixedmetalingot", 8), "RRR", "BBB", "TTT", 'R',
				"ingotTungstensteel", 'B', "ingotBronze", 'T', "ingotTin");

		CraftingHelper.addShapedOreRecipe(ItemParts.getPartByName("mixedmetalingot", 8), "RRR", "BBB", "TTT", 'R',
				"ingotTungstensteel", 'B', "ingotBronze", 'T', "ingotZinc");

		CraftingHelper.addShapedOreRecipe(ItemParts.getPartByName("mixedmetalingot", 8), "RRR", "BBB", "TTT", 'R',
				"ingotTungstensteel", 'B', "ingotBrass", 'T', "ingotTin");

		CraftingHelper.addShapedOreRecipe(ItemParts.getPartByName("mixedmetalingot", 8), "RRR", "BBB", "TTT", 'R',
				"ingotTungstensteel", 'B', "ingotBrass", 'T', "ingotZinc");

		CraftingHelper.addShapedOreRecipe(ItemParts.getPartByName("mixedmetalingot", 9), "RRR", "BBB", "TTT", 'R',
				"ingotTungstensteel", 'B', "ingotBronze", 'T', "ingotAluminum");

		CraftingHelper.addShapedOreRecipe(ItemParts.getPartByName("mixedmetalingot", 9), "RRR", "BBB", "TTT", 'R',
				"ingotTungstensteel", 'B', "ingotBrass", 'T', "ingotAluminum");

		CraftingHelper.addShapedOreRecipe(new ItemStack(ModBlocks.Compressor), "SXS", "SCS", "SMS", 'C', "circuitBasic",
				'M', BlockMachineFrame.getFrameByName("machine", 1), 'S', Blocks.stone);

		CraftingHelper.addShapedOreRecipe(new ItemStack(ModBlocks.ElectricFurnace), "XCX", "RFR", "XXX", 'C',
				"circuitBasic", 'F', new ItemStack(ModBlocks.ironFurnace), 'R', Items.redstone);

		CraftingHelper.addShapedOreRecipe(new ItemStack(ModBlocks.ironFurnace), "III", "IXI", "III", 'I', "ingotIron");

		CraftingHelper.addShapedOreRecipe(new ItemStack(ModBlocks.ironFurnace), "XIX", "IXI", "IFI", 'I', "ingotIron",
				'F', Blocks.furnace);

		CraftingHelper.addShapedOreRecipe(ItemParts.getPartByName("electronicCircuit"), "WWW", "SRS", "WWW", 'R',
				"ingotRefinedIron", 'S', Items.redstone, 'W', ItemStandaloneCables.getCableByName("insulatedcopper"));

		CraftingHelper.addShapedOreRecipe(new ItemStack(ModItems.reBattery), "XWX", "TRT", "TRT", 'T', "ingotTin", 'R',
				Items.redstone, 'W', ItemStandaloneCables.getCableByName("insulatedcopper"));

		CraftingHelper.addShapedOreRecipe(new ItemStack(ModItems.wrench), "BAB", "BBB", "ABA", 'B', "ingotBronze");

		CraftingHelper.addShapedOreRecipe(new ItemStack(ModBlocks.Extractor), "TMT", "TCT", "XXX", 'T',
				ModItems.treeTap, 'M', BlockMachineFrame.getFrameByName("machine", 1), 'C',
				ItemParts.getPartByName("electronicCircuit"));

		CraftingHelper.addShapedOreRecipe(new ItemStack(ModBlocks.centrifuge), "RCR", "AEA", "RCR", 'R',
				"ingotRefinedIron", 'E', new ItemStack(ModBlocks.Extractor), 'A', "machineBlockAdvanced", 'C',
				"circuitBasic");

		CraftingHelper.addShapedOreRecipe(ItemParts.getPartByName("advancedCircuit"), "RGR", "LCL", "RGR", 'R',
				Items.redstone, 'G', Items.glowstone_dust, 'L', "dyeBlue", 'C',
				ItemParts.getPartByName("electronicCircuit"));

		CraftingHelper.addShapedOreRecipe(new ItemStack(ModItems.energyCrystal), "RRR", "RDR", "RRR", 'R',
				Items.redstone, 'D', Items.diamond);

		CraftingHelper.addShapedOreRecipe(new ItemStack(ModItems.lapotronCrystal), "LCL", "LEL", "LCL", 'L', "dyeBlue",
				'E', new ItemStack(ModItems.energyCrystal), 'C', ItemParts.getPartByName("electronicCircuit"));

		CraftingHelper.addShapelessOreRecipe(new ItemStack(ModBlocks.Generator), batteryStack,
				BlockMachineFrame.getFrameByName("machine", 1), Blocks.furnace);

		CraftingHelper.addShapedOreRecipe(BlockMachineFrame.getFrameByName("machine", 1), "AAA", "AXA", "AAA", 'A',
				ItemIngots.getIngotByName("refinediron"));

		CraftingHelper.addShapedOreRecipe(BlockMachineFrame.getFrameByName("advancedMachine", 1), "XCX", "AMA", "XCX",
				'A', ItemParts.getPartByName("advancedAlloy"), 'C', ItemPlates.getPlateByName("carbon"), 'M',
				BlockMachineFrame.getFrameByName("machine", 1));

		CraftingHelper.addShapedOreRecipe(ItemParts.getPartByName("dataStorageCircuit"), "EEE", "ECE", "EEE", 'E',
				new ItemStack(Items.emerald), 'C', ItemParts.getPartByName("electronicCircuit"));

		CraftingHelper.addShapedOreRecipe(new ItemStack(ModItems.parts, 4, 8), "DSD", "S S", "DSD", 'D', "dustDiamond",
				'S', "ingotSteel");

		CraftingHelper.addShapedOreRecipe(new ItemStack(ModItems.parts, 1, 15), "AAA", "AMA", "AAA", 'A',
				"ingotAluminium", 'M', new ItemStack(ModItems.parts, 1, 13));

		CraftingHelper.addShapedOreRecipe(new ItemStack(ModBlocks.Supercondensator), "EOE", "SAS", "EOE", 'E',
				ItemParts.getPartByName("energyFlowCircuit"), 'O', ModItems.lapotronicOrb, 'S',
				ItemParts.getPartByName("superconductor"), 'A',
				BlockMachineFrame.getFrameByName("highlyAdvancedMachine", 1));

		CraftingHelper.addShapedOreRecipe(ItemParts.getPartByName("diamondSawBlade"), "DSD", "S S", "DSD", 'S',
				"plateSteel", 'D', "dustDiamond");

		CraftingHelper.addShapedOreRecipe(ItemParts.getPartByName("tungstenGrindingHead", 2), "TST", "SBS", "TST", 'T',
				"plateTungsten", 'S', "plateSteel", 'B', "blockSteel");

		CraftingHelper.addShapedOreRecipe(ItemParts.getPartByName("destructoPack"), "CIC", "IBI", "CIC", 'C',
				ItemParts.getPartByName("advancedCircuit"), 'I', "ingotAluminum", 'B',
				new ItemStack(Items.lava_bucket));

		CraftingHelper.addShapedOreRecipe(ItemParts.getPartByName("destructoPack"), "CIC", "IBI", "CIC", 'C',
				ItemParts.getPartByName("advancedCircuit"), 'I', "ingotRefinedIron", 'B',
				new ItemStack(Items.lava_bucket));

		CraftingHelper.addShapedOreRecipe(new ItemStack(ModItems.cloakingDevice), "CIC", "IOI", "CIC", 'C',
				"ingotChrome", 'I', "plateIridium", 'O', new ItemStack(ModItems.lapotronicOrb));

		CraftingHelper.addShapedOreRecipe(new ItemStack(ModItems.treeTap), " S ", "PPP", "P  ", 'S', "stickWood", 'P',
				"plankWood");

		CraftingHelper.addShapedOreRecipe(new ItemStack(ModItems.rockCutter), "DT ", "DT ", "DCB", 'D',
				ItemParts.getPartByName("rockCutterBlade"), 'T', "ingotTitanium", 'C',
				ItemParts.getPartByName("basicCircuitBoard"), 'B', new ItemStack(Items.diamond));

		CraftingHelper.addShapedOreRecipe(ItemParts.getPartByName("rockCutterBlade"), "SDS", "SDS", "SDS", 'D',
				new ItemStack(Items.diamond), 'S', "ingotSteel");

		for (String part : ItemParts.types) {
			if (part.endsWith("Gear")) {
				CraftingHelper.addShapedOreRecipe(ItemParts.getPartByName(part), " O ", "OIO", " O ", 'I',
						new ItemStack(Items.iron_ingot), 'O',
						"ingot" + capitalizeFirstLetter(part.replace("Gear", "")));
			}
		}

		CraftingHelper.addShapedOreRecipe(ItemParts.getPartByName("nichromeHeatingCoil"), " N ", "NCN", " N ", 'N',
				"ingotNickel", 'C', "ingotChrome");

		CraftingHelper.addShapedOreRecipe(ItemParts.getPartByName("kanthalHeatingCoil"), "III", "CAA", "AAA", 'I',
				"ingotSteel", 'C', "ingotChrome", 'A', "ingotAluminum");

		CraftingHelper.addShapedOreRecipe(ItemParts.getPartByName("heliumCoolantSimple"), " T ", "TCT", " T ", 'T',
				"ingotTin", 'C', ItemCells.getCellByName("helium", 1, false));

		CraftingHelper.addShapedOreRecipe(ItemParts.getPartByName("HeliumCoolantTriple"), "TTT", "CCC", "TTT", 'T',
				"ingotTin", 'C', ItemParts.getPartByName("heliumCoolantSimple"));

		CraftingHelper.addShapedOreRecipe(ItemParts.getPartByName("HeliumCoolantSix"), "THT", "TCT", "THT", 'T',
				"ingotTin", 'C', "ingotCopper", 'H', ItemParts.getPartByName("HeliumCoolantTriple"));

		CraftingHelper.addShapedOreRecipe(ItemParts.getPartByName("NaKCoolantTriple"), "TTT", "CCC", "TTT", 'T',
				"ingotTin", 'C', ItemParts.getPartByName("NaKCoolantSimple"));

		CraftingHelper.addShapedOreRecipe(ItemParts.getPartByName("NaKCoolantSix"), "THT", "TCT", "THT", 'T',
				"ingotTin", 'C', "ingotCopper", 'H', ItemParts.getPartByName("NaKCoolantTriple"));

		CraftingHelper.addShapedOreRecipe(new ItemStack(ModBlocks.Aesu), "LLL", "LCL", "LLL", 'L',
				new ItemStack(ModItems.lapotronicOrb), 'C', new ItemStack(ModBlocks.ComputerCube));

		CraftingHelper.addShapedOreRecipe(new ItemStack(ModBlocks.Idsu), "PAP", "ACA", "PAP", 'P',
				ItemPlates.getPlateByName("iridium"), 'C', new ItemStack(Blocks.ender_chest), 'A',
				new ItemStack(ModBlocks.Aesu));

		CraftingHelper.addShapedOreRecipe(new ItemStack(ModBlocks.FusionControlComputer), "CCC", "PTP", "CCC", 'P',
				new ItemStack(ModBlocks.ComputerCube), 'T', new ItemStack(ModBlocks.FusionCoil), 'C',
				ItemParts.getPartByName("energyFlowCircuit"));

		CraftingHelper.addShapedOreRecipe(new ItemStack(ModBlocks.LightningRod), "CAC", "ACA", "CAC", 'A',
				new ItemStack(ModBlocks.MachineCasing, 1, 2), 'S', ItemParts.getPartByName("superConductor"), 'C',
				ItemParts.getPartByName("energyFlowCircuit"));

		CraftingHelper.addShapedOreRecipe(new ItemStack(ModBlocks.FusionCoil), "CSC", "NAN", "CRC", 'A',
				new ItemStack(ModBlocks.MachineCasing, 1, 2), 'N', ItemParts.getPartByName("nichromeHeatingCoil"), 'C',
				ItemParts.getPartByName("energyFlowCircuit"), 'S', ItemParts.getPartByName("superConductor"), 'R',
				ItemParts.getPartByName("iridiumNeutronReflector"));

		CraftingHelper.addShapedOreRecipe(ItemParts.getPartByName("iridiumNeutronReflector"), "PPP", "PIP", "PPP", 'P',
				ItemParts.getPartByName("thickNeutronReflector"), 'I', "ingotIridium");

		CraftingHelper.addShapedOreRecipe(ItemParts.getPartByName("thickNeutronReflector"), " P ", "PCP", " P ", 'P',
				ItemParts.getPartByName("neutronReflector"), 'C', ItemCells.getCellByName("Berylium"));

		CraftingHelper.addShapedOreRecipe(ItemParts.getPartByName("neutronReflector"), "TCT", "CPC", "TCT", 'T',
				"dustTin", 'C', "dustCoal", 'P', "plateCopper");

		CraftingHelper.addShapedOreRecipe(new ItemStack(ModItems.scrapBox), "SSS", "SSS", "SSS", 'S',
				ItemParts.getPartByName("scrap"));

		CraftingHelper.addShapedOreRecipe(ItemUpgrades.getUpgradeByName("Overclock"), "TTT", "WCW", 'T',
				ItemParts.getPartByName("CoolantSimple"), 'W', ItemStandaloneCables.getCableByName("insulatedcopper"),
				'C', ItemParts.getPartByName("electronicCircuit"));

		CraftingHelper.addShapedOreRecipe(ItemUpgrades.getUpgradeByName("Overclock", 2), " T ", "WCW", 'T',
				ItemParts.getPartByName("heliumCoolantSimple"), 'W',
				ItemStandaloneCables.getCableByName("insulatedcopper"), 'C',
				ItemParts.getPartByName("electronicCircuit"));

		CraftingHelper.addShapedOreRecipe(ItemUpgrades.getUpgradeByName("Overclock", 2), " T ", "WCW", 'T',
				ItemParts.getPartByName("NaKCoolantSimple"), 'W',
				ItemStandaloneCables.getCableByName("insulatedcopper"), 'C',
				ItemParts.getPartByName("electronicCircuit"));

		CraftingHelper.addShapedOreRecipe(ItemUpgrades.getUpgradeByName("Transformer"), "GGG", "WTW", "GCG", 'G',
				"blockGlass", 'W', ItemStandaloneCables.getCableByName("insulatedgold"), 'C',
				ItemParts.getPartByName("electronicCircuit"), 'T', ModBlocks.mvt);

		CraftingHelper.addShapedOreRecipe(ItemUpgrades.getUpgradeByName("EnergyStorage"), "PPP", "WBW", "PCP", 'P',
				"plankWood", 'W', ItemStandaloneCables.getCableByName("insulatedcopper"), 'C',
				ItemParts.getPartByName("electronicCircuit"), 'B', ModItems.reBattery);

		CraftingHelper.addShapedOreRecipe(ItemParts.getPartByName("CoolantSimple"), " T ", "TWT", " T ", 'T',
				"ingotTin", 'W', "containerWater");

		CraftingHelper.addShapedOreRecipe(ItemParts.getPartByName("CoolantTriple"), "TTT", "CCC", "TTT", 'T',
				"ingotTin", 'C', ItemParts.getPartByName("CoolantSimple"));

		CraftingHelper.addShapedOreRecipe(ItemParts.getPartByName("CoolantSix"), "TCT", "TPT", "TCT", 'T', "ingotTin",
				'C', ItemParts.getPartByName("CoolantTriple"), 'P', ItemPlates.getPlateByName("copper"));

		CraftingHelper.addShapedOreRecipe(ItemParts.getPartByName("NaKCoolantSimple"), "TST", "PCP", "TST", 'T',
				"ingotTin", 'C', ItemParts.getPartByName("CoolantSimple"), 'S', ItemCells.getCellByName("sodium"), 'P',
				ItemCells.getCellByName("potassium"));

		CraftingHelper.addShapedOreRecipe(ItemParts.getPartByName("NaKCoolantSimple"), "TPT", "SCS", "TPT", 'T',
				"ingotTin", 'C', ItemParts.getPartByName("CoolantSimple"), 'S', ItemCells.getCellByName("sodium"), 'P',
				ItemCells.getCellByName("potassium"));

		Core.logHelper.info("Shapped Recipes Added");
	}

	public static String capitalizeFirstLetter(String original) {
		if (original.length() == 0)
			return original;
		return original.substring(0, 1).toUpperCase() + original.substring(1);
	}

	static void addShapelessRecipes() {
		for (String name : ArrayUtils.addAll(BlockStorage.types, BlockStorage2.types)) {
			ItemStack item = null;
			try {
				item = ItemIngots.getIngotByName(name, 9);
			} catch (InvalidParameterException e) {
				try {
					item = ItemGems.getGemByName(name, 9);
				} catch (InvalidParameterException e2) {
					continue;
				}
			}

			if (item == null) {
				continue;
			}

			GameRegistry.addShapelessRecipe(BlockStorage.getStorageBlockByName(name), item, item, item, item, item,
					item, item, item, item);
			GameRegistry.addShapelessRecipe(item, BlockStorage.getStorageBlockByName(name, 9));
		}

		GameRegistry.addShapelessRecipe(new ItemStack(ModBlocks.rubberPlanks, 4), ModBlocks.rubberLog);
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.frequencyTransmitter),
				ItemStandaloneCables.getCableByName("insulatedcopper"), ItemParts.getPartByName("electronicCircuit"));

		for (String name : ItemDustsSmall.types) {
			GameRegistry.addShapelessRecipe(ItemDustsSmall.getSmallDustByName(name, 4), ItemDusts.getDustByName(name));
			GameRegistry.addShapelessRecipe(ItemDusts.getDustByName(name, 1), ItemDustsSmall.getSmallDustByName(name),
					ItemDustsSmall.getSmallDustByName(name), ItemDustsSmall.getSmallDustByName(name),
					ItemDustsSmall.getSmallDustByName(name));
		}

		Core.logHelper.info("Shapeless Recipes Added");
	}

	static void addMachineRecipes() {
		CraftingHelper.addShapedOreRecipe(new ItemStack(ModBlocks.quantumTank), "EPE", "PCP", "EPE", 'P',
				"ingotPlatinum", 'E', ItemParts.getPartByName("advancedCircuit"), 'C', ModBlocks.quantumChest);

		CraftingHelper.addShapedOreRecipe(new ItemStack(ModBlocks.digitalChest), "PPP", "PDP", "PCP", 'P',
				"plateAluminum", 'D', ItemParts.getPartByName("dataOrb"), 'C',
				ItemParts.getPartByName("computerMonitor"));

		CraftingHelper.addShapedOreRecipe(new ItemStack(ModBlocks.digitalChest), "PPP", "PDP", "PCP", 'P', "plateSteel",
				'D', ItemParts.getPartByName("dataOrb"), 'C', ItemParts.getPartByName("computerMonitor"));

		CraftingHelper.addShapedOreRecipe(new ItemStack(ModBlocks.AlloySmelter), "XCX", "FMF", "XXX", 'C',
				ItemParts.getPartByName("electronicCircuit"), 'F', new ItemStack(ModBlocks.ElectricFurnace), 'M',
				BlockMachineFrame.getFrameByName("machine", 1));

		CraftingHelper.addShapedOreRecipe(new ItemStack(ModBlocks.LesuStorage), "LLL", "LCL", "LLL", 'L', "blockLapis",
				'C', ItemParts.getPartByName("electronicCircuit"));

		TechRebornAPI.addRollingOreMachinceRecipe(ItemParts.getPartByName("cupronickelHeatingCoil"), "NCN", "C C",
				"NCN", 'N', "ingotCupronickel", 'C', "ingotCopper");

		RecipeHandler.addRecipe(new VacuumFreezerRecipe(ItemIngots.getIngotByName("hotTungstensteel"),
				ItemIngots.getIngotByName("tungstensteel"), 440, 128));
		RecipeHandler.addRecipe(
				new VacuumFreezerRecipe(ItemCells.getCellByName("water"), ItemCells.getCellByName("cell"), 60, 128));
	}

	static void addSmeltingRecipes() {
		GameRegistry.addSmelting(ItemDusts.getDustByName("iron", 1), new ItemStack(Items.iron_ingot), 1F);
		GameRegistry.addSmelting(ItemDusts.getDustByName("gold", 1), new ItemStack(Items.gold_ingot), 1F);
		GameRegistry.addSmelting(ItemParts.getPartByName("rubberSap"), ItemParts.getPartByName("rubber"), 1F);
		GameRegistry.addSmelting(new ItemStack(Items.iron_ingot), ItemIngots.getIngotByName("refinediron"), 1F);
		GameRegistry.addSmelting(BlockOre2.getOreByName("copper"), ItemIngots.getIngotByName("copper"), 1F);
		GameRegistry.addSmelting(BlockOre2.getOreByName("tin"), ItemIngots.getIngotByName("tin"), 1F);

		Core.logHelper.info("Smelting Recipes Added");
	}

	static void addAlloySmelterRecipes() {

		// Bronze
		RecipeHandler.addRecipe(new AlloySmelterRecipe(ItemIngots.getIngotByName("copper", 3),
				ItemIngots.getIngotByName("tin", 1), ItemIngots.getIngotByName("bronze", 4), 200, 16));
		RecipeHandler.addRecipe(new AlloySmelterRecipe(ItemIngots.getIngotByName("copper", 3),
				ItemDusts.getDustByName("tin", 1), ItemIngots.getIngotByName("bronze", 4), 200, 16));
		RecipeHandler.addRecipe(new AlloySmelterRecipe(ItemDusts.getDustByName("copper", 3),
				ItemIngots.getIngotByName("tin", 1), ItemIngots.getIngotByName("bronze", 4), 200, 16));
		RecipeHandler.addRecipe(new AlloySmelterRecipe(ItemDusts.getDustByName("copper", 3),
				ItemDusts.getDustByName("tin", 1), ItemIngots.getIngotByName("bronze", 4), 200, 16));

		// Electrum
		RecipeHandler.addRecipe(new AlloySmelterRecipe(new ItemStack(Items.gold_ingot, 1),
				ItemIngots.getIngotByName("silver", 1), ItemIngots.getIngotByName("electrum", 2), 200, 16));
		RecipeHandler.addRecipe(new AlloySmelterRecipe(new ItemStack(Items.gold_ingot, 1),
				ItemDusts.getDustByName("silver", 1), ItemIngots.getIngotByName("electrum", 2), 200, 16));
		RecipeHandler.addRecipe(new AlloySmelterRecipe(ItemDusts.getDustByName("gold", 1),
				ItemIngots.getIngotByName("silver", 1), ItemIngots.getIngotByName("electrum", 2), 200, 16));
		RecipeHandler.addRecipe(new AlloySmelterRecipe(ItemDusts.getDustByName("gold", 1),
				ItemDusts.getDustByName("silver", 1), ItemIngots.getIngotByName("electrum", 2), 200, 16));

		// Invar
		RecipeHandler.addRecipe(new AlloySmelterRecipe(new ItemStack(Items.iron_ingot, 2),
				ItemIngots.getIngotByName("nickel", 1), ItemIngots.getIngotByName("invar", 3), 200, 16));
		RecipeHandler.addRecipe(new AlloySmelterRecipe(new ItemStack(Items.iron_ingot, 2),
				ItemDusts.getDustByName("nickel", 1), ItemIngots.getIngotByName("invar", 3), 200, 16));
		RecipeHandler.addRecipe(new AlloySmelterRecipe(ItemDusts.getDustByName("iron", 2),
				ItemIngots.getIngotByName("nickel", 1), ItemIngots.getIngotByName("invar", 3), 200, 16));
		RecipeHandler.addRecipe(new AlloySmelterRecipe(ItemDusts.getDustByName("iron", 2),
				ItemDusts.getDustByName("nickel", 1), ItemIngots.getIngotByName("invar", 3), 200, 16));

		// Cupronickel
		RecipeHandler.addRecipe(new AlloySmelterRecipe(ItemIngots.getIngotByName("copper", 1),
				ItemIngots.getIngotByName("nickel", 1), ItemIngots.getIngotByName("cupronickel", 2), 200, 16));
		RecipeHandler.addRecipe(new AlloySmelterRecipe(ItemIngots.getIngotByName("copper", 1),
				ItemDusts.getDustByName("nickel", 1), ItemIngots.getIngotByName("cupronickel", 2), 200, 16));
		RecipeHandler.addRecipe(new AlloySmelterRecipe(ItemDusts.getDustByName("copper", 1),
				ItemIngots.getIngotByName("nickel", 1), ItemIngots.getIngotByName("cupronickel", 2), 200, 16));
		RecipeHandler.addRecipe(new AlloySmelterRecipe(ItemDusts.getDustByName("copper", 1),
				ItemDusts.getDustByName("nickel", 1), ItemIngots.getIngotByName("cupronickel", 2), 200, 16));

		// Nichrome
		RecipeHandler.addRecipe(new AlloySmelterRecipe(ItemIngots.getIngotByName("chrome", 1),
				ItemIngots.getIngotByName("nickel", 4), ItemIngots.getIngotByName("nichrome", 5), 200, 16));
		RecipeHandler.addRecipe(new AlloySmelterRecipe(ItemIngots.getIngotByName("chrome", 1),
				ItemDusts.getDustByName("nickel", 4), ItemIngots.getIngotByName("nichrome", 5), 200, 16));
		RecipeHandler.addRecipe(new AlloySmelterRecipe(ItemDusts.getDustByName("chrome", 1),
				ItemIngots.getIngotByName("nickel", 4), ItemIngots.getIngotByName("nichrome", 5), 200, 16));
		RecipeHandler.addRecipe(new AlloySmelterRecipe(ItemDusts.getDustByName("chrome", 1),
				ItemDusts.getDustByName("nickel", 4), ItemIngots.getIngotByName("nichrome", 5), 200, 16));

		// Magnalium
		RecipeHandler.addRecipe(new AlloySmelterRecipe(ItemDusts.getDustByName("magnesium", 1),
				ItemIngots.getIngotByName("aluminum", 4), ItemIngots.getIngotByName("magnalium", 3), 200, 16));
		RecipeHandler.addRecipe(new AlloySmelterRecipe(ItemDusts.getDustByName("magnesium", 1),
				ItemDusts.getDustByName("aluminum", 4), ItemIngots.getIngotByName("magnalium", 3), 200, 16));

		// Battery Alloy
		RecipeHandler.addRecipe(new AlloySmelterRecipe(ItemIngots.getIngotByName("lead", 4),
				ItemIngots.getIngotByName("antimony", 1), ItemIngots.getIngotByName("batteryAlloy", 5), 200, 16));
		RecipeHandler.addRecipe(new AlloySmelterRecipe(ItemIngots.getIngotByName("lead", 4),
				ItemDusts.getDustByName("antimony", 1), ItemIngots.getIngotByName("batteryAlloy", 5), 200, 16));
		RecipeHandler.addRecipe(new AlloySmelterRecipe(ItemDusts.getDustByName("lead", 4),
				ItemIngots.getIngotByName("antimony", 1), ItemIngots.getIngotByName("batteryAlloy", 5), 200, 16));
		RecipeHandler.addRecipe(new AlloySmelterRecipe(ItemDusts.getDustByName("lead", 4),
				ItemDusts.getDustByName("antimony", 1), ItemIngots.getIngotByName("batteryAlloy", 5), 200, 16));

		// Brass
		if (OreUtil.doesOreExistAndValid("ingotBrass")) {
			ItemStack brassStack = OreDictionary.getOres("ingotBrass").get(0);
			brassStack.stackSize = 4;
			RecipeHandler.addRecipe(new AlloySmelterRecipe(ItemIngots.getIngotByName("copper", 3),
					ItemIngots.getIngotByName("zinc", 1), brassStack, 200, 16));
			RecipeHandler.addRecipe(new AlloySmelterRecipe(ItemIngots.getIngotByName("copper", 3),
					ItemDusts.getDustByName("zinc", 1), brassStack, 200, 16));
			RecipeHandler.addRecipe(new AlloySmelterRecipe(ItemDusts.getDustByName("copper", 3),
					ItemIngots.getIngotByName("zinc", 1), brassStack, 200, 16));
			RecipeHandler.addRecipe(new AlloySmelterRecipe(ItemDusts.getDustByName("copper", 3),
					ItemDusts.getDustByName("zinc", 1), brassStack, 200, 16));
		}

		// Red Alloy
		if (OreUtil.doesOreExistAndValid("ingotRedAlloy")) {
			ItemStack redAlloyStack = OreDictionary.getOres("ingotRedAlloy").get(0);
			redAlloyStack.stackSize = 1;
			RecipeHandler.addRecipe(new AlloySmelterRecipe(new ItemStack(Items.redstone, 4),
					ItemIngots.getIngotByName("copper", 1), redAlloyStack, 200, 16));
			RecipeHandler.addRecipe(new AlloySmelterRecipe(new ItemStack(Items.redstone, 4),
					new ItemStack(Items.iron_ingot, 1), redAlloyStack, 200, 16));
		}

		// Blue Alloy
		if (OreUtil.doesOreExistAndValid("ingotBlueAlloy")) {
			ItemStack blueAlloyStack = OreDictionary.getOres("ingotBlueAlloy").get(0);
			blueAlloyStack.stackSize = 1;
			RecipeHandler.addRecipe(new AlloySmelterRecipe(ItemDusts.getDustByName("teslatite", 4),
					ItemIngots.getIngotByName("silver", 1), blueAlloyStack, 200, 16));
		}

		// Blue Alloy
		if (OreUtil.doesOreExistAndValid("ingotPurpleAlloy") && OreUtil.doesOreExistAndValid("dustInfusedTeslatite")) {
			ItemStack purpleAlloyStack = OreDictionary.getOres("ingotPurpleAlloy").get(0);
			purpleAlloyStack.stackSize = 1;
			ItemStack infusedTeslatiteStack = OreDictionary.getOres("ingotPurpleAlloy").get(0);
			infusedTeslatiteStack.stackSize = 8;
			RecipeHandler.addRecipe(new AlloySmelterRecipe(ItemIngots.getIngotByName("redAlloy", 1),
					ItemIngots.getIngotByName("blueAlloy", 1), purpleAlloyStack, 200, 16));
			RecipeHandler.addRecipe(new AlloySmelterRecipe(new ItemStack(Items.gold_ingot, 1), infusedTeslatiteStack,
					purpleAlloyStack, 200, 16));
		}

		// Aluminum Brass
		if (OreUtil.doesOreExistAndValid("ingotAluminumBrass")) {
			ItemStack aluminumBrassStack = OreDictionary.getOres("ingotAluminumBrass").get(0);
			aluminumBrassStack.stackSize = 4;
			RecipeHandler.addRecipe(new AlloySmelterRecipe(ItemIngots.getIngotByName("copper", 3),
					ItemIngots.getIngotByName("aluminum", 1), aluminumBrassStack, 200, 16));
			RecipeHandler.addRecipe(new AlloySmelterRecipe(ItemIngots.getIngotByName("copper", 3),
					ItemDusts.getDustByName("aluminum", 1), aluminumBrassStack, 200, 16));
			RecipeHandler.addRecipe(new AlloySmelterRecipe(ItemDusts.getDustByName("copper", 3),
					ItemIngots.getIngotByName("aluminum", 1), aluminumBrassStack, 200, 16));
			RecipeHandler.addRecipe(new AlloySmelterRecipe(ItemDusts.getDustByName("copper", 3),
					ItemDusts.getDustByName("aluminum", 1), aluminumBrassStack, 200, 16));
		}

		// Manyullyn
		if (OreUtil.doesOreExistAndValid("ingotManyullyn") && OreUtil.doesOreExistAndValid("ingotCobalt")
				&& OreUtil.doesOreExistAndValid("ingotArdite")) {
			ItemStack manyullynStack = OreDictionary.getOres("ingotManyullyn").get(0);
			manyullynStack.stackSize = 1;
			ItemStack cobaltStack = OreDictionary.getOres("ingotCobalt").get(0);
			cobaltStack.stackSize = 1;
			ItemStack arditeStack = OreDictionary.getOres("ingotArdite").get(0);
			arditeStack.stackSize = 1;
			RecipeHandler.addRecipe(new AlloySmelterRecipe(cobaltStack, arditeStack, manyullynStack, 200, 16));
			RecipeHandler.addRecipe(
					new AlloySmelterRecipe(cobaltStack, ItemDusts.getDustByName("ardite", 1), manyullynStack, 200, 16));
			RecipeHandler.addRecipe(
					new AlloySmelterRecipe(ItemDusts.getDustByName("cobalt", 1), arditeStack, manyullynStack, 200, 16));
			RecipeHandler.addRecipe(new AlloySmelterRecipe(ItemDusts.getDustByName("cobalt", 1),
					ItemDusts.getDustByName("ardite", 1), manyullynStack, 200, 16));
		}

		// Conductive Iron
		if (OreUtil.doesOreExistAndValid("ingotConductiveIron")) {
			ItemStack conductiveIronStack = OreDictionary.getOres("ingotConductiveIron").get(0);
			conductiveIronStack.stackSize = 1;
			RecipeHandler.addRecipe(new AlloySmelterRecipe(new ItemStack(Items.redstone, 1),
					new ItemStack(Items.iron_ingot, 1), conductiveIronStack, 200, 16));
		}

		// Redstone Alloy
		if (OreUtil.doesOreExistAndValid("ingotRedstoneAlloy") && OreUtil.doesOreExistAndValid("itemSilicon")) {
			ItemStack redstoneAlloyStack = OreDictionary.getOres("ingotRedstoneAlloy").get(0);
			redstoneAlloyStack.stackSize = 1;
			ItemStack siliconStack = OreDictionary.getOres("itemSilicon").get(0);
			siliconStack.stackSize = 1;
			RecipeHandler.addRecipe(new AlloySmelterRecipe(new ItemStack(Items.redstone, 1), siliconStack,
					redstoneAlloyStack, 200, 16));
		}

		// Pulsating Iron
		if (OreUtil.doesOreExistAndValid("ingotPhasedIron")) {
			ItemStack pulsatingIronStack = OreDictionary.getOres("ingotPhasedIron").get(0);
			pulsatingIronStack.stackSize = 1;
			RecipeHandler.addRecipe(new AlloySmelterRecipe(new ItemStack(Items.iron_ingot, 1),
					new ItemStack(Items.ender_pearl, 1), pulsatingIronStack, 200, 16));
			RecipeHandler.addRecipe(new AlloySmelterRecipe(new ItemStack(Items.iron_ingot, 1),
					ItemDusts.getDustByName("enderPearl", 1), pulsatingIronStack, 200, 16));
		}

		// Vibrant Alloy
		if (OreUtil.doesOreExistAndValid("ingotEnergeticAlloy") && OreUtil.doesOreExistAndValid("ingotPhasedGold")) {
			ItemStack energeticAlloyStack = OreDictionary.getOres("ingotEnergeticAlloy").get(0);
			energeticAlloyStack.stackSize = 1;
			ItemStack vibrantAlloyStack = OreDictionary.getOres("ingotPhasedGold").get(0);
			vibrantAlloyStack.stackSize = 1;
			RecipeHandler.addRecipe(new AlloySmelterRecipe(energeticAlloyStack, new ItemStack(Items.ender_pearl, 1),
					vibrantAlloyStack, 200, 16));
			RecipeHandler.addRecipe(new AlloySmelterRecipe(energeticAlloyStack,
					ItemDusts.getDustByName("enderPearl", 1), vibrantAlloyStack, 200, 16));
		}

		// Soularium
		if (OreUtil.doesOreExistAndValid("ingotSoularium")) {
			ItemStack soulariumStack = OreDictionary.getOres("ingotSoularium").get(0);
			soulariumStack.stackSize = 1;
			RecipeHandler.addRecipe(new AlloySmelterRecipe(new ItemStack(Blocks.soul_sand, 1),
					new ItemStack(Items.gold_ingot, 1), soulariumStack, 200, 16));
		}

	}

	static void addPlateCuttingMachineRecipes() {

		for (String ore : OreUtil.oreNames) {
			if (OreUtil.hasBlock(ore) && OreUtil.hasPlate(ore)) {
				RecipeHandler.addRecipe(
						new PlateCuttingMachineRecipe(OreUtil.getStackFromName("block" + capitalizeFirstLetter(ore)),
								OreUtil.getStackFromName("plate" + capitalizeFirstLetter(ore), 9), 200, 16));
			}
		}

		// Obsidian
		RecipeHandler.addRecipe(new PlateCuttingMachineRecipe(new ItemStack(Blocks.obsidian),
				ItemPlates.getPlateByName("obsidian", 9), 100, 4));
	}

	static void addIndustrialSawmillRecipes() {
		ItemStack pulpStack = OreDictionary.getOres("pulpWood").get(0);
		RecipeHandler.addRecipe(new IndustrialSawmillRecipe(new ItemStack(Blocks.log, 1, 0), null,
				new FluidStack(FluidRegistry.WATER, 1000), new ItemStack(Blocks.planks, 6, 0), pulpStack, null, 200, 30,
				false));
		RecipeHandler.addRecipe(
				new IndustrialSawmillRecipe(new ItemStack(Blocks.log, 1, 0), new ItemStack(Items.water_bucket), null,
						new ItemStack(Blocks.planks, 6, 0), pulpStack, new ItemStack(Items.bucket), 200, 30, false));

		RecipeHandler.addRecipe(new IndustrialSawmillRecipe(new ItemStack(Blocks.log, 1, 1), null,
				new FluidStack(FluidRegistry.WATER, 1000), new ItemStack(Blocks.planks, 6, 1), pulpStack, null, 200, 30,
				false));
		RecipeHandler.addRecipe(
				new IndustrialSawmillRecipe(new ItemStack(Blocks.log, 1, 1), new ItemStack(Items.water_bucket), null,
						new ItemStack(Blocks.planks, 6, 1), pulpStack, new ItemStack(Items.bucket), 200, 30, false));

		RecipeHandler.addRecipe(new IndustrialSawmillRecipe(new ItemStack(Blocks.log, 1, 2), null,
				new FluidStack(FluidRegistry.WATER, 1000), new ItemStack(Blocks.planks, 6, 2), pulpStack, null, 200, 30,
				false));
		RecipeHandler.addRecipe(
				new IndustrialSawmillRecipe(new ItemStack(Blocks.log, 1, 2), new ItemStack(Items.water_bucket), null,
						new ItemStack(Blocks.planks, 6, 2), pulpStack, new ItemStack(Items.bucket), 200, 30, false));

		RecipeHandler.addRecipe(new IndustrialSawmillRecipe(new ItemStack(Blocks.log, 1, 3), null,
				new FluidStack(FluidRegistry.WATER, 1000), new ItemStack(Blocks.planks, 6, 3), pulpStack, null, 200, 30,
				false));
		RecipeHandler.addRecipe(
				new IndustrialSawmillRecipe(new ItemStack(Blocks.log, 1, 3), new ItemStack(Items.water_bucket), null,
						new ItemStack(Blocks.planks, 6, 3), pulpStack, new ItemStack(Items.bucket), 200, 30, false));

		RecipeHandler.addRecipe(new IndustrialSawmillRecipe(new ItemStack(Blocks.log2, 1, 0), null,
				new FluidStack(FluidRegistry.WATER, 1000), new ItemStack(Blocks.planks, 6, 4), pulpStack, null, 200, 30,
				false));
		RecipeHandler.addRecipe(
				new IndustrialSawmillRecipe(new ItemStack(Blocks.log2, 1, 0), new ItemStack(Items.water_bucket), null,
						new ItemStack(Blocks.planks, 6, 4), pulpStack, new ItemStack(Items.bucket), 200, 30, false));

		RecipeHandler.addRecipe(new IndustrialSawmillRecipe(new ItemStack(Blocks.log2, 1, 1), null,
				new FluidStack(FluidRegistry.WATER, 1000), new ItemStack(Blocks.planks, 6, 5), pulpStack, null, 200, 30,
				false));
		RecipeHandler.addRecipe(
				new IndustrialSawmillRecipe(new ItemStack(Blocks.log2, 1, 1), new ItemStack(Items.water_bucket), null,
						new ItemStack(Blocks.planks, 6, 5), pulpStack, new ItemStack(Items.bucket), 200, 30, false));
	}

	static void addBlastFurnaceRecipes() {
		RecipeHandler.addRecipe(new BlastFurnaceRecipe(ItemDusts.getDustByName("titanium"), null,
				ItemIngots.getIngotByName("titanium"), null, 3600, 120, 1500));
		RecipeHandler.addRecipe(new BlastFurnaceRecipe(ItemDustsSmall.getSmallDustByName("titanium", 4), null,
				ItemIngots.getIngotByName("titanium"), null, 3600, 120, 1500));
		// RecipeHandler.addRecipe(new
		// BlastFurnaceRecipe(ItemDustsTiny.getTinyDustByName("titanium", 9),
		// null, ItemIngots.getIngotByName("titanium"), null, 3600, 120, 1500));
		RecipeHandler.addRecipe(new BlastFurnaceRecipe(ItemDusts.getDustByName("aluminum"), null,
				ItemIngots.getIngotByName("aluminum"), null, 2200, 120, 1700));
		RecipeHandler.addRecipe(new BlastFurnaceRecipe(ItemDustsSmall.getSmallDustByName("aluminum", 4), null,
				ItemIngots.getIngotByName("aluminum"), null, 2200, 120, 1700));
		// RecipeHandler.addRecipe(new
		// BlastFurnaceRecipe(ItemDustsTiny.getTinyDustByName("aluminum", 9),
		// null, ItemIngots.getIngotByName("aluminum"), null, 2200, 120, 1700));
		RecipeHandler.addRecipe(new BlastFurnaceRecipe(ItemDusts.getDustByName("kanthal"), null,
				ItemIngots.getIngotByName("kanthal"), null, 5500, 120, 2500));
		RecipeHandler.addRecipe(new BlastFurnaceRecipe(ItemDustsSmall.getSmallDustByName("kanthal", 4), null,
				ItemIngots.getIngotByName("kanthal"), null, 5500, 120, 2500));
		// RecipeHandler.addRecipe(new
		// BlastFurnaceRecipe(ItemDustsTiny.getTinyDustByName("kanthal", 9),
		// null, ItemIngots.getIngotByName("kanthal"), null, 5500, 120, 2500));
		RecipeHandler.addRecipe(new BlastFurnaceRecipe(ItemDusts.getDustByName("tungsten"), null,
				ItemIngots.getIngotByName("tungsten"), null, 18000, 120, 2500));
		RecipeHandler.addRecipe(new BlastFurnaceRecipe(ItemDustsSmall.getSmallDustByName("tungsten", 4), null,
				ItemIngots.getIngotByName("tungsten"), null, 18000, 120, 2500));
		// RecipeHandler.addRecipe(new
		// BlastFurnaceRecipe(ItemDustsTiny.getTinyDustByName("tungsten", 9),
		// null, ItemIngots.getIngotByName("tungsten"), null, 18000, 120,
		// 2500));
		RecipeHandler.addRecipe(new BlastFurnaceRecipe(ItemDusts.getDustByName("chrome"), null,
				ItemIngots.getIngotByName("chrome"), null, 4420, 120, 1700));
		RecipeHandler.addRecipe(new BlastFurnaceRecipe(ItemDustsSmall.getSmallDustByName("chrome", 4), null,
				ItemIngots.getIngotByName("chrome"), null, 4420, 120, 1700));
		// RecipeHandler.addRecipe(new
		// BlastFurnaceRecipe(ItemDustsTiny.getTinyDustByName("chrome", 9),
		// null, ItemIngots.getIngotByName("chrome"), null, 4420, 120, 1700));
		RecipeHandler.addRecipe(new BlastFurnaceRecipe(ItemDusts.getDustByName("steel"), null,
				ItemIngots.getIngotByName("steel"), null, 2800, 120, 1000));
		RecipeHandler.addRecipe(new BlastFurnaceRecipe(ItemDustsSmall.getSmallDustByName("steel", 4), null,
				ItemIngots.getIngotByName("steel"), null, 2800, 120, 1000));
		// RecipeHandler.addRecipe(new
		// BlastFurnaceRecipe(ItemDustsTiny.getTinyDustByName("steel", 9), null,
		// ItemIngots.getIngotByName("steel"), null, 2800, 120, 1000));

		RecipeHandler.addRecipe(new BlastFurnaceRecipe(ItemDusts.getDustByName("galena", 2), null,
				ItemIngots.getIngotByName("silver"), ItemIngots.getIngotByName("lead"), 80, 120, 1500));

		RecipeHandler
				.addRecipe(new BlastFurnaceRecipe(new ItemStack(Items.iron_ingot), ItemDusts.getDustByName("coal", 2),
						ItemIngots.getIngotByName("steel"), ItemDusts.getDustByName("darkAshes", 2), 500, 120, 1000));

		RecipeHandler.addRecipe(new BlastFurnaceRecipe(ItemIngots.getIngotByName("tungsten"),
				ItemIngots.getIngotByName("steel"), ItemIngots.getIngotByName("hotTungstensteel"),
				ItemDusts.getDustByName("darkAshes", 4), 500, 500, 3000));

		RecipeHandler
				.addRecipe(new BlastFurnaceRecipe(new ItemStack(Blocks.iron_ore), ItemDusts.getDustByName("calcite"),
						new ItemStack(Items.iron_ingot, 3), ItemDusts.getDustByName("darkAshes"), 140, 120, 1000));

		RecipeHandler
				.addRecipe(new BlastFurnaceRecipe(BlockOre.getOreByName("Pyrite"), ItemDusts.getDustByName("calcite"),
						new ItemStack(Items.iron_ingot, 2), ItemDusts.getDustByName("darkAshes"), 140, 120, 1000));
	}

	static void addUUrecipes() {

		if (ConfigTechReborn.UUrecipesWood)
			CraftingHelper.addShapedOreRecipe(new ItemStack(Blocks.log, 8), " U ", "   ", "   ", 'U',
					ModItems.uuMatter);

		if (ConfigTechReborn.UUrecipesStone)
			CraftingHelper.addShapedOreRecipe(new ItemStack(Blocks.stone, 16), "   ", " U ", "   ", 'U',
					ModItems.uuMatter);

		if (ConfigTechReborn.UUrecipesSnowBlock)
			CraftingHelper.addShapedOreRecipe(new ItemStack(Blocks.snow, 16), "U U", "   ", "   ", 'U',
					ModItems.uuMatter);

		if (ConfigTechReborn.UUrecipesGrass)
			CraftingHelper.addShapedOreRecipe(new ItemStack(Blocks.grass, 16), "   ", "U  ", "U  ", 'U',
					ModItems.uuMatter);

		if (ConfigTechReborn.UUrecipesObsidian)
			CraftingHelper.addShapedOreRecipe(new ItemStack(Blocks.obsidian, 12), "U U", "U U", "   ", 'U',
					ModItems.uuMatter);

		if (ConfigTechReborn.UUrecipesGlass)
			CraftingHelper.addShapedOreRecipe(new ItemStack(Blocks.glass, 32), " U ", "U U", " U ", 'U',
					ModItems.uuMatter);

		if (ConfigTechReborn.UUrecipesCocoa)
			CraftingHelper.addShapedOreRecipe(new ItemStack(Items.dye, 32, 3), "UU ", "  U", "UU ", 'U',
					ModItems.uuMatter);

		if (ConfigTechReborn.UUrecipesGlowstoneBlock)
			CraftingHelper.addShapedOreRecipe(new ItemStack(Blocks.glowstone, 8), " U ", "U U", "UUU", 'U',
					ModItems.uuMatter);

		if (ConfigTechReborn.UUrecipesCactus)
			CraftingHelper.addShapedOreRecipe(new ItemStack(Blocks.cactus, 48), " U ", "UUU", "U U", 'U',
					ModItems.uuMatter);

		if (ConfigTechReborn.UUrecipesSugarCane)
			CraftingHelper.addShapedOreRecipe(new ItemStack(Items.reeds, 48), "U U", "U U", "U U", 'U',
					ModItems.uuMatter);

		if (ConfigTechReborn.UUrecipesVine)
			CraftingHelper.addShapedOreRecipe(new ItemStack(Blocks.vine, 24), "U  ", "U  ", "U  ", 'U',
					ModItems.uuMatter);

		if (ConfigTechReborn.UUrecipesSnowBall)
			CraftingHelper.addShapedOreRecipe(new ItemStack(Items.snowball, 16), "   ", "   ", "UUU", 'U',
					ModItems.uuMatter);

		CraftingHelper.addShapedOreRecipe(new ItemStack(Items.clay_ball, 48), "UU ", "U  ", "UU ", 'U',
				ModItems.uuMatter);

		if (ConfigTechReborn.UUrecipeslilypad)
			CraftingHelper.addShapedOreRecipe(new ItemStack(Blocks.waterlily, 64), "U U", " U ", " U ", 'U',
					ModItems.uuMatter);

		if (ConfigTechReborn.UUrecipesGunpowder)
			CraftingHelper.addShapedOreRecipe(new ItemStack(Items.gunpowder, 15), "UUU", "U  ", "UUU", 'U',
					ModItems.uuMatter);

		if (ConfigTechReborn.UUrecipesBone)
			CraftingHelper.addShapedOreRecipe(new ItemStack(Items.bone, 32), "U  ", "UU ", "U  ", 'U',
					ModItems.uuMatter);

		if (ConfigTechReborn.UUrecipesFeather)
			CraftingHelper.addShapedOreRecipe(new ItemStack(Items.feather, 32), " U ", " U ", "U U", 'U',
					ModItems.uuMatter);

		if (ConfigTechReborn.UUrecipesInk)
			CraftingHelper.addShapedOreRecipe(new ItemStack(Items.dye, 48), " UU", " UU", " U ", 'U',
					ModItems.uuMatter);

		if (ConfigTechReborn.UUrecipesEnderPearl)
			CraftingHelper.addShapedOreRecipe(new ItemStack(Items.ender_pearl, 1), "UUU", "U U", " U ", 'U',
					ModItems.uuMatter);

		if (ConfigTechReborn.UUrecipesCoal)
			CraftingHelper.addShapedOreRecipe(new ItemStack(Items.coal, 5), "  U", "U  ", "  U", 'U',
					ModItems.uuMatter);

		if (ConfigTechReborn.UUrecipesIronOre)
			CraftingHelper.addShapedOreRecipe(new ItemStack(Blocks.iron_ore, 2), "U U", " U ", "U U", 'U',
					ModItems.uuMatter);

		if (ConfigTechReborn.UUrecipesGoldOre)
			CraftingHelper.addShapedOreRecipe(new ItemStack(Blocks.gold_ore, 2), " U ", "UUU", " U ", 'U',
					ModItems.uuMatter);

		if (ConfigTechReborn.UUrecipesRedStone)
			CraftingHelper.addShapedOreRecipe(new ItemStack(Items.redstone, 24), "   ", " U ", "UUU", 'U',
					ModItems.uuMatter);

		if (ConfigTechReborn.UUrecipesLapis)
			CraftingHelper.addShapedOreRecipe(new ItemStack(Items.dye, 9, 4), " U ", " U ", " UU", 'U',
					ModItems.uuMatter);

		if (ConfigTechReborn.UUrecipesEmeraldOre)
			CraftingHelper.addShapedOreRecipe(new ItemStack(Blocks.emerald_ore, 1), "UU ", "U U", " UU", 'U',
					ModItems.uuMatter);

		if (ConfigTechReborn.UUrecipesEmerald)
			CraftingHelper.addShapedOreRecipe(new ItemStack(Items.emerald, 2), "UUU", "UUU", " U ", 'U',
					ModItems.uuMatter);

		if (ConfigTechReborn.UUrecipesDiamond)
			CraftingHelper.addShapedOreRecipe(new ItemStack(Items.diamond, 1), "UUU", "UUU", "UUU", 'U',
					ModItems.uuMatter);

		if (ConfigTechReborn.UUrecipesTinDust)
			CraftingHelper.addShapedOreRecipe(new ItemStack(ModItems.dusts, 10, 77), "   ", "U U", "  U", 'U',
					ModItems.uuMatter);

		if (ConfigTechReborn.UUrecipesCopperDust)
			CraftingHelper.addShapedOreRecipe(new ItemStack(ModItems.dusts, 10, 21), "  U", "U U", "   ", 'U',
					ModItems.uuMatter);

		if (ConfigTechReborn.UUrecipesLeadDust)
			CraftingHelper.addShapedOreRecipe(new ItemStack(ModItems.dusts, 14, 42), "UUU", "UUU", "U  ", 'U',
					ModItems.uuMatter);

		if (ConfigTechReborn.UUrecipesPlatinumDust)
			CraftingHelper.addShapedOreRecipe(new ItemStack(ModItems.dusts, 1, 58), "  U", "UUU", "UUU", 'U',
					ModItems.uuMatter);

		if (ConfigTechReborn.UUrecipesTungstenDust)
			CraftingHelper.addShapedOreRecipe(new ItemStack(ModItems.dusts, 1, 79), "U  ", "UUU", "UUU", 'U',
					ModItems.uuMatter);

		if (ConfigTechReborn.UUrecipesTitaniumDust)
			CraftingHelper.addShapedOreRecipe(new ItemStack(ModItems.dusts, 2, 78), "UUU", " U ", " U ", 'U',
					ModItems.uuMatter);

		if (ConfigTechReborn.UUrecipesAluminumDust)
			CraftingHelper.addShapedOreRecipe(new ItemStack(ModItems.dusts, 16, 2), " U ", " U ", "UUU", 'U',
					ModItems.uuMatter);

		if (ConfigTechReborn.HideUuRecipes)
			hideUUrecipes();

	}

	static void hideUUrecipes() {
		// TODO
	}

	static void addIndustrialCentrifugeRecipes() {

		// Mycelium Byproducts
		RecipeHandler.addRecipe(new CentrifugeRecipe(new ItemStack(Blocks.mycelium, 8), null,
				new ItemStack(Blocks.brown_mushroom, 2), new ItemStack(Blocks.red_mushroom, 2),
				new ItemStack(Items.clay_ball, 1), new ItemStack(Blocks.sand, 4), 1640, 5));

		// Blaze Powder Byproducts
		RecipeHandler.addRecipe(new CentrifugeRecipe(new ItemStack(Items.blaze_powder), null,
				ItemDusts.getDustByName("darkAshes", 1), ItemDusts.getDustByName("sulfur", 1), null, null, 1240, 5));

		// Magma Cream Products
		RecipeHandler.addRecipe(new CentrifugeRecipe(new ItemStack(Items.magma_cream, 1), null,
				new ItemStack(Items.blaze_powder, 1), new ItemStack(Items.slime_ball, 1), null, null, 2500, 5));

		// Dust Byproducts
		// RecipeHandler.addRecipe(new
		// CentrifugeRecipe(ItemDusts.getDustByName("platinum", 1), null,
		// ItemDustsTiny.getTinyDustByName("Iridium", 1),
		// ItemDustsSmall.getSmallDustByName("Nickel", 1), null, null, 3000,
		// 5));
		RecipeHandler.addRecipe(new CentrifugeRecipe(ItemDusts.getDustByName("electrum", 2), null,
				ItemDusts.getDustByName("silver", 1), ItemDusts.getDustByName("gold", 1), null, null, 2400, 5));
		RecipeHandler.addRecipe(new CentrifugeRecipe(ItemDusts.getDustByName("invar", 3), null,
				ItemDusts.getDustByName("iron", 2), ItemDusts.getDustByName("nickel", 1), null, null, 1340, 5));
		RecipeHandler.addRecipe(new CentrifugeRecipe(ItemDusts.getDustByName("marble", 8), null,
				ItemDusts.getDustByName("magnesium", 1), ItemDusts.getDustByName("calcite", 7), null, null, 1280, 5));
		RecipeHandler.addRecipe(
				new CentrifugeRecipe(ItemDusts.getDustByName("redrock", 4), null, ItemDusts.getDustByName("calcite", 2),
						ItemDusts.getDustByName("flint", 1), ItemDusts.getDustByName("clay", 1), null, 640, 5));
		RecipeHandler.addRecipe(new CentrifugeRecipe(ItemDusts.getDustByName("basalt", 16), null,
				ItemDusts.getDustByName("peridot", 1), ItemDusts.getDustByName("calcite", 3),
				ItemDusts.getDustByName("magnesium", 8), ItemDusts.getDustByName("darkAshes", 4), 2680, 5));
		RecipeHandler.addRecipe(new CentrifugeRecipe(ItemDusts.getDustByName("yellowGarnet", 16), null,
				ItemDusts.getDustByName("andradite", 5), ItemDusts.getDustByName("grossular", 8),
				ItemDusts.getDustByName("uvarovite", 3), null, 2940, 5));
		RecipeHandler.addRecipe(new CentrifugeRecipe(ItemDusts.getDustByName("redGarnet", 16), null,
				ItemDusts.getDustByName("pyrope", 3), ItemDusts.getDustByName("almandine", 5),
				ItemDusts.getDustByName("spessartine", 8), null, 2940, 5));
		RecipeHandler.addRecipe(new CentrifugeRecipe(ItemDusts.getDustByName("darkAshes", 2), null,
				ItemDusts.getDustByName("ashes", 2), null, null, null, 240, 5));
		RecipeHandler.addRecipe(new CentrifugeRecipe(ItemDusts.getDustByName("manyullyn", 2), null,
				ItemDusts.getDustByName("cobalt", 1), ItemDusts.getDustByName("ardite", 1), null, null, 1240, 5));
		RecipeHandler.addRecipe(new CentrifugeRecipe(ItemDusts.getDustByName("nichrome", 5), null,
				ItemDusts.getDustByName("nickel", 4), ItemDusts.getDustByName("chrome", 1), null, null, 2240, 5));
		RecipeHandler.addRecipe(new CentrifugeRecipe(ItemDusts.getDustByName("cupronickel", 2), null,
				ItemDusts.getDustByName("copper", 1), ItemDusts.getDustByName("nickel", 1), null, null, 960, 5));
		RecipeHandler.addRecipe(
				new CentrifugeRecipe(ItemDusts.getDustByName("kanthal", 3), null, ItemDusts.getDustByName("iron", 1),
						ItemDusts.getDustByName("aluminum", 1), ItemDusts.getDustByName("chrome", 1), null, 1040, 5));
		RecipeHandler.addRecipe(new CentrifugeRecipe(ItemDusts.getDustByName("brass", 4), null,
				ItemDusts.getDustByName("zinc", 1), ItemDusts.getDustByName("copper", 3), null, null, 2000, 5));
		RecipeHandler.addRecipe(new CentrifugeRecipe(ItemDusts.getDustByName("aluminumBrass", 4), null,
				ItemDusts.getDustByName("aluminum", 1), ItemDusts.getDustByName("copper", 3), null, null, 2000, 5));
		RecipeHandler.addRecipe(new CentrifugeRecipe(ItemDusts.getDustByName("bronze", 4), null,
				ItemDusts.getDustByName("tin", 1), ItemDusts.getDustByName("copper", 3), null, null, 2420, 5));
		RecipeHandler.addRecipe(new CentrifugeRecipe(ItemDusts.getDustByName("netherrack", 16), null,
				new ItemStack(Items.redstone, 1), ItemDusts.getDustByName("sulfur", 4),
				ItemDusts.getDustByName("basalt", 1), new ItemStack(Items.gold_nugget, 1), 2400, 5));
		RecipeHandler.addRecipe(new CentrifugeRecipe(ItemDusts.getDustByName("enderEye", 1), null,
				ItemDusts.getDustByName("enderPearl", 1), new ItemStack(Items.blaze_powder, 1), null, null, 1280, 5));
		RecipeHandler.addRecipe(new CentrifugeRecipe(ItemDusts.getDustByName("tetrahedrite", 8), null,
				ItemDusts.getDustByName("copper", 3), ItemDusts.getDustByName("antimony", 1),
				ItemDusts.getDustByName("sulfur", 3), ItemDusts.getDustByName("iron", 1), 3640, 5));
		RecipeHandler.addRecipe(new CentrifugeRecipe(ItemDusts.getDustByName("lapis", 16), null,
				ItemDusts.getDustByName("lazurite", 12), ItemDusts.getDustByName("sodalite", 2),
				ItemDusts.getDustByName("pyrite", 7), ItemDusts.getDustByName("calcite", 1), 3580, 5));

		RecipeHandler.addRecipe(new CentrifugeRecipe(new ItemStack(Items.glowstone_dust, 16),
				RecipeUtils.getEmptyCell(1), ItemCells.getCellByName("helium", 1, false),
				ItemDusts.getDustByName("gold", 8), new ItemStack(Items.redstone), null, 25000, 20));
		// RecipeHandler.addRecipe(new
		// CentrifugeRecipe(ItemDusts.getDustByName("endstone", 16),
		// RecipeUtils.getEmptyCell(2), ItemCells.getCellByName("helium3", 1,
		// false), ItemCells.getCellByName("helium", 1, false),
		// ItemDustsTiny.getTinyDustByName("Tungsten"), new
		// ItemStack(Blocks.sand, 12), 4800, 5));
	}

	static void addIndustrialGrinderRecipes() {
		for (String ore : OreUtil.oreNames) {
			if (OreUtil.hasIngot(ore) && OreUtil.hasDustSmall(ore) && OreUtil.hasBlock(ore)) {
				RecipeHandler.addRecipe(
						new IndustrialGrinderRecipe(OreUtil.getStackFromName("block" + capitalizeFirstLetter(ore)),
								null, new FluidStack(FluidRegistry.WATER, 1000),
								OreUtil.getStackFromName("ingot" + capitalizeFirstLetter(ore)),
								OreUtil.getStackFromName("dustSmall" + capitalizeFirstLetter(ore), 6),
								OreUtil.getStackFromName("dustSmall" + capitalizeFirstLetter(ore), 2), null, 100, 120));
				RecipeHandler.addRecipe(
						new IndustrialGrinderRecipe(OreUtil.getStackFromName("block" + capitalizeFirstLetter(ore)),
								new ItemStack(Items.water_bucket), null,
								OreUtil.getStackFromName("ingot" + capitalizeFirstLetter(ore)),
								OreUtil.getStackFromName("dustSmall" + capitalizeFirstLetter(ore), 6),
								OreUtil.getStackFromName("dustSmall" + capitalizeFirstLetter(ore), 2),
								new ItemStack(Items.bucket), 100, 120));
			}
		}

		// Copper Ore
		if (OreUtil.doesOreExistAndValid("oreCopper")) {
			try {
				ItemStack oreStack = OreDictionary.getOres("oreCopper").get(0);
				RecipeHandler.addRecipe(
						new IndustrialGrinderRecipe(oreStack, null, new FluidStack(FluidRegistry.WATER, 1000),
								ItemDusts.getDustByName("copper", 2), ItemDustsSmall.getSmallDustByName("Gold", 1),
								ItemDustsSmall.getSmallDustByName("Nickel", 1), null, 100, 120));
				RecipeHandler.addRecipe(new IndustrialGrinderRecipe(oreStack, new ItemStack(Items.water_bucket), null,
						ItemDusts.getDustByName("copper", 2), ItemDustsSmall.getSmallDustByName("Gold", 1),
						ItemDustsSmall.getSmallDustByName("Nickel", 1), new ItemStack(Items.bucket), 100, 120));

				RecipeHandler.addRecipe(new IndustrialGrinderRecipe(oreStack, null,
						new FluidStack(ModFluids.fluidSodiumpersulfate, 1000), ItemDusts.getDustByName("copper", 2),
						ItemDusts.getDustByName("gold", 1), ItemDustsSmall.getSmallDustByName("Nickel", 1), null, 100,
						120));
				RecipeHandler
						.addRecipe(new IndustrialGrinderRecipe(oreStack, new ItemStack(ModItems.bucketSodiumpersulfate),
								null, ItemDusts.getDustByName("copper", 2), ItemDusts.getDustByName("gold", 1),
								ItemDustsSmall.getSmallDustByName("Nickel", 1), new ItemStack(Items.bucket), 100, 120));

				RecipeHandler.addRecipe(
						new IndustrialGrinderRecipe(oreStack, null, new FluidStack(ModFluids.fluidMercury, 1000),
								ItemDusts.getDustByName("copper", 2), ItemDustsSmall.getSmallDustByName("Gold", 1),
								ItemDusts.getDustByName("nickel", 1), null, 100, 120));
				RecipeHandler.addRecipe(new IndustrialGrinderRecipe(oreStack, ItemCells.getCellByName("mercury", 1),
						null, ItemDusts.getDustByName("copper", 2), ItemDustsSmall.getSmallDustByName("Gold", 1),
						ItemDusts.getDustByName("nickel", 1), new ItemStack(Items.bucket), 100, 120));
			} catch (Exception e) {
				Core.logHelper.info("Failed to Load Grinder Recipe for Copper Ore");
			}
		}

		// Tin Ore
		if (OreUtil.doesOreExistAndValid("oreTin")) {
			try {
				ItemStack oreStack = OreDictionary.getOres("oreTin").get(0);
				RecipeHandler.addRecipe(
						new IndustrialGrinderRecipe(oreStack, null, new FluidStack(FluidRegistry.WATER, 1000),
								ItemDusts.getDustByName("tin", 2), ItemDustsSmall.getSmallDustByName("Iron", 1),
								ItemDustsSmall.getSmallDustByName("Zinc", 1), null, 100, 120));
				RecipeHandler.addRecipe(new IndustrialGrinderRecipe(oreStack, new ItemStack(Items.water_bucket), null,
						ItemDusts.getDustByName("tin", 2), ItemDustsSmall.getSmallDustByName("Iron", 1),
						ItemDustsSmall.getSmallDustByName("Zinc", 1), new ItemStack(Items.bucket), 100, 120));

				RecipeHandler.addRecipe(new IndustrialGrinderRecipe(oreStack, null,
						new FluidStack(ModFluids.fluidSodiumpersulfate, 1000), ItemDusts.getDustByName("tin", 2),
						ItemDustsSmall.getSmallDustByName("Iron", 1), ItemDusts.getDustByName("zinc", 1), null, 100,
						120));
				RecipeHandler
						.addRecipe(new IndustrialGrinderRecipe(oreStack, new ItemStack(ModItems.bucketSodiumpersulfate),
								null, ItemDusts.getDustByName("tin", 2), ItemDustsSmall.getSmallDustByName("Iron", 1),
								ItemDusts.getDustByName("zinc", 1), new ItemStack(Items.bucket), 100, 120));
			} catch (Exception e) {
				Core.logHelper.info("Failed to Load Grinder Recipe for Tin Ore");
			}
		}

		// Nickel Ore
		if (OreUtil.doesOreExistAndValid("oreNickel")) {
			try {
				ItemStack oreStack = OreDictionary.getOres("oreNickel").get(0);
				RecipeHandler.addRecipe(
						new IndustrialGrinderRecipe(oreStack, null, new FluidStack(FluidRegistry.WATER, 1000),
								ItemDusts.getDustByName("nickel", 2), ItemDustsSmall.getSmallDustByName("Iron", 1),
								ItemDustsSmall.getSmallDustByName("Platinum", 1), null, 100, 120));
				RecipeHandler.addRecipe(new IndustrialGrinderRecipe(oreStack, new ItemStack(Items.water_bucket), null,
						ItemDusts.getDustByName("nickel", 2), ItemDustsSmall.getSmallDustByName("Iron", 1),
						ItemDustsSmall.getSmallDustByName("Platinum", 1), new ItemStack(Items.bucket), 100, 120));

				RecipeHandler.addRecipe(new IndustrialGrinderRecipe(oreStack, null,
						new FluidStack(ModFluids.fluidSodiumpersulfate, 1000), ItemDusts.getDustByName("nickel", 3),
						ItemDustsSmall.getSmallDustByName("Iron", 1), ItemDustsSmall.getSmallDustByName("Platinum", 1),
						null, 100, 120));
				RecipeHandler.addRecipe(new IndustrialGrinderRecipe(oreStack,
						new ItemStack(ModItems.bucketSodiumpersulfate), null, ItemDusts.getDustByName("nickel", 3),
						ItemDustsSmall.getSmallDustByName("Iron", 1), ItemDustsSmall.getSmallDustByName("Platinum", 1),
						new ItemStack(Items.bucket), 100, 120));

				RecipeHandler.addRecipe(
						new IndustrialGrinderRecipe(oreStack, null, new FluidStack(ModFluids.fluidMercury, 1000),
								ItemDusts.getDustByName("nickel", 2), ItemDustsSmall.getSmallDustByName("Iron", 1),
								ItemDusts.getDustByName("platinum", 1), null, 100, 120));
				RecipeHandler.addRecipe(new IndustrialGrinderRecipe(oreStack, new ItemStack(ModItems.bucketMercury),
						null, ItemDusts.getDustByName("nickel", 2), ItemDustsSmall.getSmallDustByName("Iron", 1),
						ItemDusts.getDustByName("platinum", 1), new ItemStack(Items.bucket), 100, 120));
			} catch (Exception e) {
				Core.logHelper.info("Failed to Load Grinder Recipe for Nickel Ore");
			}
		}

		// Zinc Ore
		if (OreUtil.doesOreExistAndValid("oreZinc")) {
			try {
				ItemStack oreStack = OreDictionary.getOres("oreZinc").get(0);
				RecipeHandler.addRecipe(
						new IndustrialGrinderRecipe(oreStack, null, new FluidStack(FluidRegistry.WATER, 1000),
								ItemDusts.getDustByName("zinc", 2), ItemDustsSmall.getSmallDustByName("Iron", 1),
								ItemDustsSmall.getSmallDustByName("Tin", 1), null, 100, 120));
				RecipeHandler.addRecipe(new IndustrialGrinderRecipe(oreStack, new ItemStack(Items.water_bucket), null,
						ItemDusts.getDustByName("zinc", 2), ItemDustsSmall.getSmallDustByName("Iron", 1),
						ItemDustsSmall.getSmallDustByName("Tin", 1), new ItemStack(Items.bucket), 100, 120));

				RecipeHandler.addRecipe(new IndustrialGrinderRecipe(oreStack, null,
						new FluidStack(ModFluids.fluidSodiumpersulfate, 1000), ItemDusts.getDustByName("zinc", 2),
						ItemDustsSmall.getSmallDustByName("Iron", 1), ItemDusts.getDustByName("iron", 1), null, 100,
						120));
				RecipeHandler
						.addRecipe(new IndustrialGrinderRecipe(oreStack, new ItemStack(ModItems.bucketSodiumpersulfate),
								null, ItemDusts.getDustByName("zinc", 2), ItemDustsSmall.getSmallDustByName("Iron", 1),
								ItemDusts.getDustByName("iron", 1), new ItemStack(Items.bucket), 100, 120));
			} catch (Exception e) {
				Core.logHelper.info("Failed to Load Grinder Recipe for Zinc Ore");
			}
		}

		// Silver Ore
		if (OreUtil.doesOreExistAndValid("oreSilver")) {
			try {
				ItemStack oreStack = OreDictionary.getOres("oreSilver").get(0);
				RecipeHandler.addRecipe(
						new IndustrialGrinderRecipe(oreStack, null, new FluidStack(FluidRegistry.WATER, 1000),
								ItemDusts.getDustByName("silver", 2), ItemDustsSmall.getSmallDustByName("Lead", 1),
								ItemDustsSmall.getSmallDustByName("Sulfur", 1), null, 100, 120));
				RecipeHandler.addRecipe(new IndustrialGrinderRecipe(oreStack, new ItemStack(Items.water_bucket), null,
						ItemDusts.getDustByName("silver", 2), ItemDustsSmall.getSmallDustByName("Lead", 1),
						ItemDustsSmall.getSmallDustByName("Sulfur", 1), new ItemStack(Items.bucket), 100, 120));

				RecipeHandler.addRecipe(
						new IndustrialGrinderRecipe(oreStack, null, new FluidStack(ModFluids.fluidMercury, 1000),
								ItemDusts.getDustByName("silver", 3), ItemDustsSmall.getSmallDustByName("Lead", 1),
								ItemDustsSmall.getSmallDustByName("Sulfur", 1), null, 100, 120));
				RecipeHandler.addRecipe(new IndustrialGrinderRecipe(oreStack, new ItemStack(ModItems.bucketMercury),
						null, ItemDusts.getDustByName("silver", 3), ItemDustsSmall.getSmallDustByName("Lead", 1),
						ItemDustsSmall.getSmallDustByName("Sulfur", 1), new ItemStack(Items.bucket), 100, 120));
			} catch (Exception e) {
				Core.logHelper.info("Failed to Load Grinder Recipe for Silver Ore");
			}
		}

		// Lead Ore
		if (OreUtil.doesOreExistAndValid("oreLead")) {
			try {
				ItemStack oreStack = OreDictionary.getOres("oreLead").get(0);
				RecipeHandler.addRecipe(
						new IndustrialGrinderRecipe(oreStack, null, new FluidStack(FluidRegistry.WATER, 1000),
								ItemDusts.getDustByName("lead", 2), ItemDustsSmall.getSmallDustByName("Silver", 1),
								ItemDustsSmall.getSmallDustByName("Sulfur", 1), null, 100, 120));
				RecipeHandler.addRecipe(new IndustrialGrinderRecipe(oreStack, new ItemStack(Items.water_bucket), null,
						ItemDusts.getDustByName("lead", 2), ItemDustsSmall.getSmallDustByName("Silver", 1),
						ItemDustsSmall.getSmallDustByName("Sulfur", 1), new ItemStack(Items.bucket), 100, 120));

				RecipeHandler.addRecipe(
						new IndustrialGrinderRecipe(oreStack, null, new FluidStack(ModFluids.fluidMercury, 1000),
								ItemDusts.getDustByName("lead", 2), ItemDusts.getDustByName("silver", 1),
								ItemDustsSmall.getSmallDustByName("Sulfur", 1), null, 100, 120));
				RecipeHandler.addRecipe(new IndustrialGrinderRecipe(oreStack, new ItemStack(ModItems.bucketMercury),
						null, ItemDusts.getDustByName("lead", 2), ItemDusts.getDustByName("silver", 1),
						ItemDustsSmall.getSmallDustByName("Sulfur", 1), new ItemStack(Items.bucket), 100, 120));
			} catch (Exception e) {
				Core.logHelper.info("Failed to Load Grinder Recipe for Lead Ore");
			}
		}

		// Apatite Ore
		if (OreUtil.doesOreExistAndValid("oreApatite") & OreUtil.doesOreExistAndValid("gemApatite")) {
			try {
				ItemStack oreStack = OreDictionary.getOres("oreApatite").get(0);
				ItemStack gemStack = OreDictionary.getOres("gemApatite").get(0);
				gemStack.stackSize = 6;
				RecipeHandler.addRecipe(
						new IndustrialGrinderRecipe(oreStack, null, new FluidStack(FluidRegistry.WATER, 1000), gemStack,
								gemStack, ItemDustsSmall.getSmallDustByName("Phosphorous", 4), null, 100, 120));
				RecipeHandler.addRecipe(new IndustrialGrinderRecipe(oreStack, new ItemStack(Items.water_bucket), null,
						gemStack, gemStack, ItemDustsSmall.getSmallDustByName("Phosphorous", 4),
						new ItemStack(Items.bucket), 100, 120));
			} catch (Exception e) {
				Core.logHelper.info("Failed to Load Grinder Recipe for Apatite Ore");
			}
		}

		// Nether Quartz Ore
		if (OreUtil.doesOreExistAndValid("dustNetherQuartz")) {
			try {
				ItemStack dustStack = OreDictionary.getOres("dustNetherQuartz").get(0);
				dustStack.stackSize = 4;
				RecipeHandler.addRecipe(new IndustrialGrinderRecipe(new ItemStack(Blocks.quartz_ore, 1), null,
						new FluidStack(FluidRegistry.WATER, 1000), new ItemStack(Items.quartz, 2), dustStack,
						ItemDustsSmall.getSmallDustByName("Netherrack", 2), null, 100, 120));
				RecipeHandler.addRecipe(new IndustrialGrinderRecipe(new ItemStack(Blocks.quartz_ore, 1),
						new ItemStack(Items.water_bucket), null, new ItemStack(Items.quartz, 2), dustStack,
						ItemDustsSmall.getSmallDustByName("Netherrack", 2), new ItemStack(Items.bucket), 100, 120));
			} catch (Exception e) {
				Core.logHelper.info("Failed to Load Grinder Recipe for Nether Quartz Ore");
			}
		}

		// Certus Quartz Ore
		if (OreUtil.doesOreExistAndValid("oreCertusQuartz")) {
			try {
				ItemStack oreStack = OreDictionary.getOres("oreCertusQuartz").get(0);
				ItemStack gemStack = OreDictionary.getOres("crystalCertusQuartz").get(0);
				ItemStack dustStack = OreDictionary.getOres("dustCertusQuartz").get(0);
				dustStack.stackSize = 2;
				RecipeHandler.addRecipe(new IndustrialGrinderRecipe(oreStack, null,
						new FluidStack(FluidRegistry.WATER, 1000), gemStack, dustStack, null, null, 100, 120));
				RecipeHandler.addRecipe(new IndustrialGrinderRecipe(oreStack, new ItemStack(Items.water_bucket), null,
						gemStack, dustStack, null, new ItemStack(Items.bucket), 100, 120));
			} catch (Exception e) {
				Core.logHelper.info("Failed to Load Grinder Recipe for Certus Quartz Ore");
			}
		}

		// Charged Certus Quartz Ore
		if (OreUtil.doesOreExistAndValid("oreChargedCertusQuartz")) {
			try {
				ItemStack oreStack = OreDictionary.getOres("oreChargedCertusQuartz").get(0);
				ItemStack gemStack = OreDictionary.getOres("crystalChargedCertusQuartz").get(0);
				ItemStack dustStack = OreDictionary.getOres("dustCertusQuartz").get(0);
				dustStack.stackSize = 2;
				RecipeHandler.addRecipe(new IndustrialGrinderRecipe(oreStack, null,
						new FluidStack(FluidRegistry.WATER, 1000), gemStack, dustStack, null, null, 100, 120));
				RecipeHandler.addRecipe(new IndustrialGrinderRecipe(oreStack, new ItemStack(Items.water_bucket), null,
						gemStack, dustStack, null, new ItemStack(Items.bucket), 100, 120));
			} catch (Exception e) {
				Core.logHelper.info("Failed to Load Grinder Recipe for Charged Certus Quartz Ore");
			}
		}

		// Amethyst Ore
		if (OreUtil.doesOreExistAndValid("oreAmethyst") && OreUtil.doesOreExistAndValid("gemAmethyst")) {
			try {
				ItemStack oreStack = OreDictionary.getOres("oreAmethyst").get(0);
				ItemStack gemStack = OreDictionary.getOres("gemAmethyst").get(0);
				gemStack.stackSize = 2;
				ItemStack dustStack = OreDictionary.getOres("gemAmethyst").get(0);
				dustStack.stackSize = 1;
				RecipeHandler.addRecipe(new IndustrialGrinderRecipe(oreStack, null,
						new FluidStack(FluidRegistry.WATER, 1000), gemStack, dustStack, null, null, 100, 120));
				RecipeHandler.addRecipe(new IndustrialGrinderRecipe(oreStack, new ItemStack(Items.water_bucket), null,
						gemStack, dustStack, null, new ItemStack(Items.bucket), 100, 120));
			} catch (Exception e) {
				Core.logHelper.info("Failed to Load Grinder Recipe for Certus Quartz Ore");
			}
		}

		// Topaz Ore
		if (OreUtil.doesOreExistAndValid("oreTopaz") && OreUtil.doesOreExistAndValid("gemTopaz")) {
			try {
				ItemStack oreStack = OreDictionary.getOres("oreTopaz").get(0);
				ItemStack gemStack = OreDictionary.getOres("gemTopaz").get(0);
				gemStack.stackSize = 2;
				ItemStack dustStack = OreDictionary.getOres("gemTopaz").get(0);
				dustStack.stackSize = 1;
				RecipeHandler.addRecipe(new IndustrialGrinderRecipe(oreStack, null,
						new FluidStack(FluidRegistry.WATER, 1000), gemStack, dustStack, null, null, 100, 120));
				RecipeHandler.addRecipe(new IndustrialGrinderRecipe(oreStack, new ItemStack(Items.water_bucket), null,
						gemStack, dustStack, null, new ItemStack(Items.bucket), 100, 120));
			} catch (Exception e) {
				Core.logHelper.info("Failed to Load Grinder Recipe for Topaz Ore");
			}
		}

		// Tanzanite Ore
		if (OreUtil.doesOreExistAndValid("oreTanzanite") && OreUtil.doesOreExistAndValid("gemTanzanite")) {
			try {
				ItemStack oreStack = OreDictionary.getOres("oreTanzanite").get(0);
				ItemStack gemStack = OreDictionary.getOres("gemTanzanite").get(0);
				gemStack.stackSize = 2;
				ItemStack dustStack = OreDictionary.getOres("gemTanzanite").get(0);
				dustStack.stackSize = 1;
				RecipeHandler.addRecipe(new IndustrialGrinderRecipe(oreStack, null,
						new FluidStack(FluidRegistry.WATER, 1000), gemStack, dustStack, null, null, 100, 120));
				RecipeHandler.addRecipe(new IndustrialGrinderRecipe(oreStack, new ItemStack(Items.water_bucket), null,
						gemStack, dustStack, null, new ItemStack(Items.bucket), 100, 120));
			} catch (Exception e) {
				Core.logHelper.info("Failed to Load Grinder Recipe for Tanzanite Ore");
			}
		}

		// Malachite Ore
		if (OreUtil.doesOreExistAndValid("oreMalachite") && OreUtil.doesOreExistAndValid("gemMalachite")) {
			try {
				ItemStack oreStack = OreDictionary.getOres("oreMalachite").get(0);
				ItemStack gemStack = OreDictionary.getOres("gemMalachite").get(0);
				gemStack.stackSize = 2;
				ItemStack dustStack = OreDictionary.getOres("gemMalachite").get(0);
				dustStack.stackSize = 1;
				RecipeHandler.addRecipe(new IndustrialGrinderRecipe(oreStack, null,
						new FluidStack(FluidRegistry.WATER, 1000), gemStack, dustStack, null, null, 100, 120));
				RecipeHandler.addRecipe(new IndustrialGrinderRecipe(oreStack, new ItemStack(Items.water_bucket), null,
						gemStack, dustStack, null, new ItemStack(Items.bucket), 100, 120));
			} catch (Exception e) {
				Core.logHelper.info("Failed to Load Grinder Recipe for Malachite Ore");
			}
		}

		// Galena Ore
		RecipeHandler.addRecipe(new IndustrialGrinderRecipe(new ItemStack(ModBlocks.ore, 1, 0), null,
				new FluidStack(FluidRegistry.WATER, 1000), ItemDusts.getDustByName("galena", 2),
				ItemDustsSmall.getSmallDustByName("Sulfur", 1), ItemDustsSmall.getSmallDustByName("Silver", 1), null,
				100, 120));
		RecipeHandler.addRecipe(
				new IndustrialGrinderRecipe(new ItemStack(ModBlocks.ore, 1, 0), new ItemStack(Items.water_bucket), null,
						ItemDusts.getDustByName("galena", 2), ItemDustsSmall.getSmallDustByName("Sulfur", 1),
						ItemDustsSmall.getSmallDustByName("Silver", 1), new ItemStack(Items.bucket), 100, 120));

		RecipeHandler.addRecipe(new IndustrialGrinderRecipe(new ItemStack(ModBlocks.ore, 1, 0), null,
				new FluidStack(ModFluids.fluidMercury, 1000), ItemDusts.getDustByName("galena", 2),
				ItemDustsSmall.getSmallDustByName("Sulfur", 1), ItemDusts.getDustByName("silver", 1), null, 100, 120));
		RecipeHandler.addRecipe(
				new IndustrialGrinderRecipe(new ItemStack(ModBlocks.ore, 1, 0), new ItemStack(ModItems.bucketMercury),
						null, ItemDusts.getDustByName("galena", 2), ItemDustsSmall.getSmallDustByName("Sulfur", 1),
						ItemDusts.getDustByName("silver", 1), new ItemStack(Items.bucket), 100, 120));

		// Ruby Ore
		RecipeHandler.addRecipe(new IndustrialGrinderRecipe(new ItemStack(ModBlocks.ore, 1, 2), null,
				new FluidStack(FluidRegistry.WATER, 1000), ItemGems.getGemByName("ruby", 1),
				ItemDustsSmall.getSmallDustByName("Ruby", 6), ItemDustsSmall.getSmallDustByName("Chrome", 2), null, 100,
				120));
		RecipeHandler.addRecipe(
				new IndustrialGrinderRecipe(new ItemStack(ModBlocks.ore, 1, 2), new ItemStack(Items.water_bucket), null,
						ItemGems.getGemByName("ruby", 1), ItemDustsSmall.getSmallDustByName("Ruby", 6),
						ItemDustsSmall.getSmallDustByName("Chrome", 2), new ItemStack(Items.bucket), 100, 120));

		// Sapphire Ore
		RecipeHandler.addRecipe(new IndustrialGrinderRecipe(new ItemStack(ModBlocks.ore, 1, 3), null,
				new FluidStack(FluidRegistry.WATER, 1000), ItemGems.getGemByName("sapphire", 1),
				ItemDustsSmall.getSmallDustByName("Sapphire", 6), ItemDustsSmall.getSmallDustByName("Aluminum", 2),
				null, 100, 120));
		RecipeHandler.addRecipe(
				new IndustrialGrinderRecipe(new ItemStack(ModBlocks.ore, 1, 3), new ItemStack(Items.water_bucket), null,
						ItemGems.getGemByName("sapphire", 1), ItemDustsSmall.getSmallDustByName("Sapphire", 6),
						ItemDustsSmall.getSmallDustByName("Aluminum", 2), new ItemStack(Items.bucket), 100, 120));

		// Bauxite Ore
		RecipeHandler.addRecipe(new IndustrialGrinderRecipe(new ItemStack(ModBlocks.ore, 1, 4), null,
				new FluidStack(FluidRegistry.WATER, 1000), ItemDusts.getDustByName("bauxite", 2),
				ItemDustsSmall.getSmallDustByName("Grossular", 4), ItemDustsSmall.getSmallDustByName("Titanium", 4),
				null, 100, 120));
		RecipeHandler.addRecipe(
				new IndustrialGrinderRecipe(new ItemStack(ModBlocks.ore, 1, 4), new ItemStack(Items.water_bucket), null,
						ItemDusts.getDustByName("bauxite", 2), ItemDustsSmall.getSmallDustByName("Grossular", 4),
						ItemDustsSmall.getSmallDustByName("Titanium", 4), new ItemStack(Items.bucket), 100, 120));

		// Pyrite Ore
		RecipeHandler.addRecipe(new IndustrialGrinderRecipe(new ItemStack(ModBlocks.ore, 1, 5), null,
				new FluidStack(FluidRegistry.WATER, 1000), ItemDusts.getDustByName("pyrite", 2),
				ItemDustsSmall.getSmallDustByName("Sulfur", 1), ItemDustsSmall.getSmallDustByName("Phosphorous", 1),
				null, 100, 120));
		RecipeHandler.addRecipe(
				new IndustrialGrinderRecipe(new ItemStack(ModBlocks.ore, 1, 5), new ItemStack(Items.water_bucket), null,
						ItemDusts.getDustByName("pyrite", 2), ItemDustsSmall.getSmallDustByName("Sulfur", 1),
						ItemDustsSmall.getSmallDustByName("Phosphorous", 1), new ItemStack(Items.bucket), 100, 120));

		// Cinnabar Ore
		RecipeHandler.addRecipe(new IndustrialGrinderRecipe(new ItemStack(ModBlocks.ore, 1, 6), null,
				new FluidStack(FluidRegistry.WATER, 1000), ItemDusts.getDustByName("cinnabar", 2),
				ItemDustsSmall.getSmallDustByName("Redstone", 1), ItemDustsSmall.getSmallDustByName("Glowstone", 1),
				null, 100, 120));
		RecipeHandler.addRecipe(
				new IndustrialGrinderRecipe(new ItemStack(ModBlocks.ore, 1, 6), new ItemStack(Items.water_bucket), null,
						ItemDusts.getDustByName("cinnabar", 2), ItemDustsSmall.getSmallDustByName("Redstone", 1),
						ItemDustsSmall.getSmallDustByName("Glowstone", 1), new ItemStack(Items.bucket), 100, 120));

		// Sphalerite Ore
		RecipeHandler.addRecipe(new IndustrialGrinderRecipe(new ItemStack(ModBlocks.ore, 1, 7), null,
				new FluidStack(FluidRegistry.WATER, 1000), ItemDusts.getDustByName("sphalerite", 2),
				ItemDustsSmall.getSmallDustByName("Zinc", 1), ItemDustsSmall.getSmallDustByName("YellowGarnet", 1),
				null, 100, 120));
		RecipeHandler.addRecipe(
				new IndustrialGrinderRecipe(new ItemStack(ModBlocks.ore, 1, 7), new ItemStack(Items.water_bucket), null,
						ItemDusts.getDustByName("sphalerite", 2), ItemDustsSmall.getSmallDustByName("Zinc", 1),
						ItemDustsSmall.getSmallDustByName("YellowGarnet", 1), new ItemStack(Items.bucket), 100, 120));

		RecipeHandler.addRecipe(new IndustrialGrinderRecipe(new ItemStack(ModBlocks.ore, 1, 7), null,
				new FluidStack(ModFluids.fluidSodiumpersulfate, 1000), ItemDusts.getDustByName("sphalerite", 2),
				ItemDusts.getDustByName("zinc", 1), ItemDustsSmall.getSmallDustByName("YellowGarnet", 1), null, 100,
				120));
		RecipeHandler.addRecipe(new IndustrialGrinderRecipe(new ItemStack(ModBlocks.ore, 1, 7),
				new ItemStack(ModItems.bucketSodiumpersulfate), null, ItemDusts.getDustByName("sphalerite", 2),
				ItemDusts.getDustByName("zinc", 1), ItemDustsSmall.getSmallDustByName("YellowGarnet", 1),
				new ItemStack(Items.bucket), 100, 120));

		// Tungsten Ore
		RecipeHandler.addRecipe(new IndustrialGrinderRecipe(new ItemStack(ModBlocks.ore, 1, 8), null,
				new FluidStack(FluidRegistry.WATER, 1000), ItemDusts.getDustByName("tungsten", 2),
				ItemDustsSmall.getSmallDustByName("Manganese", 1), ItemDustsSmall.getSmallDustByName("Silver", 1), null,
				100, 120));
		RecipeHandler.addRecipe(
				new IndustrialGrinderRecipe(new ItemStack(ModBlocks.ore, 1, 8), new ItemStack(Items.water_bucket), null,
						ItemDusts.getDustByName("tungsten", 2), ItemDustsSmall.getSmallDustByName("Manganese", 1),
						ItemDustsSmall.getSmallDustByName("Silver", 1), new ItemStack(Items.bucket), 100, 120));

		RecipeHandler.addRecipe(new IndustrialGrinderRecipe(new ItemStack(ModBlocks.ore, 1, 8), null,
				new FluidStack(ModFluids.fluidMercury, 1000), ItemDusts.getDustByName("tungsten", 2),
				ItemDustsSmall.getSmallDustByName("Manganese", 1), ItemDusts.getDustByName("silver", 2), null, 100,
				120));
		RecipeHandler.addRecipe(
				new IndustrialGrinderRecipe(new ItemStack(ModBlocks.ore, 1, 8), new ItemStack(ModItems.bucketMercury),
						null, ItemDusts.getDustByName("tungsten", 2), ItemDustsSmall.getSmallDustByName("Manganese", 1),
						ItemDusts.getDustByName("silver", 2), new ItemStack(Items.bucket), 100, 120));

		// Sheldonite Ore
		RecipeHandler.addRecipe(new IndustrialGrinderRecipe(new ItemStack(ModBlocks.ore, 1, 9), null,
				new FluidStack(FluidRegistry.WATER, 1000), ItemDusts.getDustByName("platinum", 2),
				ItemDustsSmall.getSmallDustByName("Iridium", 1), ItemDustsSmall.getSmallDustByName("Iridium", 1), null,
				100, 120));
		RecipeHandler.addRecipe(
				new IndustrialGrinderRecipe(new ItemStack(ModBlocks.ore, 1, 9), new ItemStack(Items.water_bucket), null,
						ItemDusts.getDustByName("platinum", 2), ItemDustsSmall.getSmallDustByName("Iridium", 1),
						ItemDustsSmall.getSmallDustByName("Iridium", 1), new ItemStack(Items.bucket), 100, 120));

		RecipeHandler.addRecipe(new IndustrialGrinderRecipe(new ItemStack(ModBlocks.ore, 1, 9), null,
				new FluidStack(ModFluids.fluidMercury, 1000), ItemDusts.getDustByName("platinum", 3),
				ItemDustsSmall.getSmallDustByName("Iridium", 1), ItemDustsSmall.getSmallDustByName("Iridium", 1), null,
				100, 120));
		RecipeHandler.addRecipe(
				new IndustrialGrinderRecipe(new ItemStack(ModBlocks.ore, 1, 9), new ItemStack(ModItems.bucketMercury),
						null, ItemDusts.getDustByName("platinum", 3), ItemDustsSmall.getSmallDustByName("Iridium", 1),
						ItemDustsSmall.getSmallDustByName("Iridium", 1), new ItemStack(Items.bucket), 100, 120));

		// Peridot Ore
		RecipeHandler.addRecipe(new IndustrialGrinderRecipe(new ItemStack(ModBlocks.ore, 1, 10), null,
				new FluidStack(FluidRegistry.WATER, 1000), ItemGems.getGemByName("peridot", 1),
				ItemDustsSmall.getSmallDustByName("Peridot", 6), ItemDustsSmall.getSmallDustByName("Pyrope", 2), null,
				100, 120));
		RecipeHandler.addRecipe(
				new IndustrialGrinderRecipe(new ItemStack(ModBlocks.ore, 1, 10), new ItemStack(Items.water_bucket),
						null, ItemGems.getGemByName("peridot", 1), ItemDustsSmall.getSmallDustByName("Peridot", 6),
						ItemDustsSmall.getSmallDustByName("Pyrope", 2), new ItemStack(Items.bucket), 100, 120));

		// Sodalite Ore
		RecipeHandler.addRecipe(new IndustrialGrinderRecipe(new ItemStack(ModBlocks.ore, 1, 11), null,
				new FluidStack(FluidRegistry.WATER, 1000), ItemDusts.getDustByName("sodalite", 12),
				ItemDustsSmall.getSmallDustByName("Lazurite", 4), ItemDustsSmall.getSmallDustByName("Lapis", 4), null,
				100, 120));
		RecipeHandler.addRecipe(
				new IndustrialGrinderRecipe(new ItemStack(ModBlocks.ore, 1, 11), new ItemStack(Items.water_bucket),
						null, ItemDusts.getDustByName("sodalite", 12), ItemDustsSmall.getSmallDustByName("Lazurite", 4),
						ItemDustsSmall.getSmallDustByName("Lapis", 4), new ItemStack(Items.bucket), 100, 120));

		// Tetrahedrite Ore
		RecipeHandler.addRecipe(new IndustrialGrinderRecipe(new ItemStack(ModBlocks.ore, 1, 12), null,
				new FluidStack(FluidRegistry.WATER, 1000), ItemDusts.getDustByName("tetrahedrite", 2),
				ItemDustsSmall.getSmallDustByName("Antimony", 1), ItemDustsSmall.getSmallDustByName("Zinc", 1), null,
				100, 120));
		RecipeHandler.addRecipe(new IndustrialGrinderRecipe(new ItemStack(ModBlocks.ore, 1, 12),
				new ItemStack(Items.water_bucket), null, ItemDusts.getDustByName("tetrahedrite", 2),
				ItemDustsSmall.getSmallDustByName("Antimony", 1), ItemDustsSmall.getSmallDustByName("Zinc", 1),
				new ItemStack(Items.bucket), 100, 120));

		RecipeHandler.addRecipe(new IndustrialGrinderRecipe(new ItemStack(ModBlocks.ore, 1, 12), null,
				new FluidStack(ModFluids.fluidSodiumpersulfate, 1000), ItemDusts.getDustByName("tetrahedrite", 3),
				ItemDustsSmall.getSmallDustByName("Antimony", 1), ItemDustsSmall.getSmallDustByName("Zinc", 1), null,
				100, 120));
		RecipeHandler.addRecipe(new IndustrialGrinderRecipe(new ItemStack(ModBlocks.ore, 1, 12),
				new ItemStack(ModItems.bucketSodiumpersulfate), null, ItemDusts.getDustByName("tetrahedrite", 3),
				ItemDustsSmall.getSmallDustByName("Antimony", 1), ItemDustsSmall.getSmallDustByName("Zinc", 1),
				new ItemStack(Items.bucket), 100, 120));
	}

	static void addImplosionCompressorRecipes() {
	}

	static void addChemicalReactorRecipes() {
		RecipeHandler.addRecipe(new ChemicalReactorRecipe(ItemCells.getCellByName("calcium", 1),
				ItemCells.getCellByName("carbon", 1), ItemCells.getCellByName("calciumCarbonate", 2), 240, 30));
		RecipeHandler.addRecipe(new ChemicalReactorRecipe(new ItemStack(Items.gold_nugget, 8),
				new ItemStack(Items.melon, 1), new ItemStack(Items.speckled_melon, 1), 40, 30));
		RecipeHandler.addRecipe(new ChemicalReactorRecipe(ItemCells.getCellByName("nitrogen", 1),
				ItemCells.getCellByName("carbon", 1), ItemCells.getCellByName("nitrocarbon", 2), 1500, 30));
		RecipeHandler.addRecipe(new ChemicalReactorRecipe(ItemCells.getCellByName("carbon", 1),
				ItemCells.getCellByName("hydrogen", 4), ItemCells.getCellByName("methane", 5), 3500, 30));
		RecipeHandler.addRecipe(new ChemicalReactorRecipe(ItemCells.getCellByName("sulfur", 1),
				ItemCells.getCellByName("sodium", 1), ItemCells.getCellByName("sodiumSulfide", 2), 100, 30));
		RecipeHandler.addRecipe(new ChemicalReactorRecipe(new ItemStack(Items.blaze_powder, 1),
				new ItemStack(Items.ender_pearl, 1), new ItemStack(Items.ender_eye, 1), 40, 30));
		RecipeHandler.addRecipe(new ChemicalReactorRecipe(new ItemStack(Items.gold_nugget, 8),
				new ItemStack(Items.carrot, 1), new ItemStack(Items.golden_carrot, 1), 40, 30));
		RecipeHandler.addRecipe(new ChemicalReactorRecipe(ItemCells.getCellByName("glyceryl", 1),
				ItemCells.getCellByName("diesel", 4), ItemCells.getCellByName("nitroDiesel", 5), 1000, 30));
		RecipeHandler.addRecipe(new ChemicalReactorRecipe(new ItemStack(Items.gold_ingot, 8),
				new ItemStack(Items.apple, 1), new ItemStack(Items.golden_apple, 1), 40, 30));
		RecipeHandler.addRecipe(new ChemicalReactorRecipe(new ItemStack(Blocks.gold_block, 8),
				new ItemStack(Items.apple, 1), new ItemStack(Items.golden_apple, 1, 1), 40, 30));
		RecipeHandler.addRecipe(new ChemicalReactorRecipe(new ItemStack(Items.blaze_powder, 1),
				new ItemStack(Items.slime_ball, 1), new ItemStack(Items.magma_cream, 1), 40, 30));
	}

	static void addIndustrialElectrolyzerRecipes() {

		RecipeHandler.addRecipe(new IndustrialElectrolyzerRecipe(ItemCells.getCellByName("nitrocarbon", 2), null,
				ItemCells.getCellByName("nitrogen"), ItemCells.getCellByName("carbon"), null, null, 80, 60));

		RecipeHandler.addRecipe(new IndustrialElectrolyzerRecipe(ItemDusts.getDustByName("pyrite", 3), null,
				ItemDusts.getDustByName("iron"), ItemDusts.getDustByName("sulfur"), null, null, 120, 128));

		RecipeHandler.addRecipe(new IndustrialElectrolyzerRecipe(ItemDusts.getDustByName("sphalerite", 2), null,
				ItemDusts.getDustByName("zinc"), ItemDusts.getDustByName("sulfur"), null, null, 150, 100));

	}

	static void addIc2Recipes() {
		CraftingHelper.addShapelessOreRecipe(new ItemStack(ModItems.manual), ItemIngots.getIngotByName("refinedIron"),
				Items.book);

		CraftingHelper.addShapedOreRecipe(ItemParts.getPartByName("machineParts", 16), "CSC", "SCS", "CSC", 'S',
				"ingotSteel", 'C', TechRebornAPI.recipeCompact.getItem("electronicCircuit"));

		CraftingHelper.addShapedOreRecipe(ItemParts.getPartByName("energyFlowCircuit", 4), "ATA", "LIL", "ATA", 'T',
				"ingotTungsten", 'I', "plateIridium", 'A', TechRebornAPI.recipeCompact.getItem("advancedCircuit"), 'L',
				TechRebornAPI.recipeCompact.getItem("lapotronCrystal"));

		CraftingHelper.addShapedOreRecipe(ItemParts.getPartByName("superconductor", 4), "CCC", "TIT", "EEE", 'E',
				ItemParts.getPartByName("energyFlowCircuit"), 'C', ItemParts.getPartByName("heliumCoolantSimple"), 'T',
				"ingotTungsten", 'I', TechRebornAPI.recipeCompact.getItem("iridiumPlate"));

		CraftingHelper
				.addShapedOreRecipe(new ItemStack(ModItems.lapotronicOrb), "LLL", "LPL", "LLL", 'L',
						new ItemStack(TechRebornAPI.recipeCompact.getItem("lapotronCrystal").getItem(), 1,
								OreDictionary.WILDCARD_VALUE),
						'P', TechRebornAPI.recipeCompact.getItem("iridiumPlate"));

		CraftingHelper.addShapedOreRecipe(new ItemStack(ModBlocks.industrialSawmill), "PAP", "SSS", "ACA", 'P',
				ItemIngots.getIngotByName("refinedIron"), 'A', TechRebornAPI.recipeCompact.getItem("advancedCircuit"),
				'S', ItemParts.getPartByName("diamondSawBlade"), 'C',
				TechRebornAPI.recipeCompact.getItem("advancedMachine"));

		CraftingHelper.addShapedOreRecipe(new ItemStack(ModBlocks.ComputerCube), "DME", "MAM", "EMD", 'E',
				ItemParts.getPartByName("energyFlowCircuit"), 'D', ItemParts.getPartByName("dataOrb"), 'M',
				ItemParts.getPartByName("computerMonitor"), 'A',
				TechRebornAPI.recipeCompact.getItem("advancedMachine"));

		CraftingHelper.addShapedOreRecipe(new ItemStack(ModBlocks.MatterFabricator), "ETE", "AOA", "ETE", 'E',
				ItemParts.getPartByName("energyFlowCircuit"), 'T', ModBlocks.Extractor, 'A',
				BlockMachineFrame.getFrameByName("highlyAdvancedMachine", 1), 'O', ModItems.lapotronicOrb);

		CraftingHelper.addShapedOreRecipe(new ItemStack(ModBlocks.heatGenerator), "III", "IHI", "CGC", 'I', "plateIron",
				'H', new ItemStack(Blocks.iron_bars), 'C', "circuitBasic", 'G', ModBlocks.Generator);

		CraftingHelper.addShapedOreRecipe(new ItemStack(ModBlocks.Gasturbine), "IAI", "WGW", "IAI", 'I', "ingotInvar",
				'A', TechRebornAPI.recipeCompact.getItem("advancedCircuit"), 'W',
				TechRebornAPI.recipeCompact.getItem("windMill"), 'G',
				TechRebornAPI.recipeCompact.getItem("reinforcedGlass"));

		CraftingHelper.addShapedOreRecipe(new ItemStack(ModBlocks.Gasturbine), "IAI", "WGW", "IAI", 'I',
				"ingotAluminum", 'A', TechRebornAPI.recipeCompact.getItem("advancedCircuit"), 'W',
				TechRebornAPI.recipeCompact.getItem("windMill"), 'G',
				TechRebornAPI.recipeCompact.getItem("reinforcedGlass"));

		CraftingHelper.addShapedOreRecipe(new ItemStack(ModBlocks.Semifluidgenerator), "III", "IHI", "CGC", 'I',
				"plateIron", 'H', ModBlocks.reinforcedglass, 'C', ItemParts.getPartByName("electronicCircuit"), 'G',
				ModBlocks.Generator);

		CraftingHelper.addShapedOreRecipe(new ItemStack(ModBlocks.Semifluidgenerator), "AAA", "AHA", "CGC", 'A',
				"plateAluminum", 'H', ModBlocks.reinforcedglass, 'C', ItemParts.getPartByName("electronicCircuit"), 'G',
				ModBlocks.Generator);

		CraftingHelper.addShapedOreRecipe(new ItemStack(ModBlocks.DieselGenerator), "III", "I I", "CGC", 'I',
				"refinedIron", 'C', ItemParts.getPartByName("electronicCircuit"), 'G', ModBlocks.Generator);

		CraftingHelper.addShapedOreRecipe(new ItemStack(ModBlocks.DieselGenerator), "AAA", "A A", "CGC", 'A',
				"ingotAluminum", 'C', ItemParts.getPartByName("electronicCircuit"), 'G', ModBlocks.Generator);

		// CraftingHelper.addShapedOreRecipe(new
		// ItemStack(ModBlocks.MagicalAbsorber),
		// "CSC", "IBI", "CAC",
		// 'C', "circuitMaster",
		// 'S', "craftingSuperconductor",
		// 'B', Blocks.beacon,
		// 'A', ModBlocks.Magicenergeyconverter,
		// 'I', TechRebornAPI.recipeCompact.getItem("iridiumPlate"));
		//
		// CraftingHelper.addShapedOreRecipe(new
		// ItemStack(ModBlocks.Magicenergeyconverter),
		// "CTC", "PBP", "CLC",
		// 'C', "circuitAdvanced",
		// 'P', "platePlatinum",
		// 'B', Blocks.beacon,
		// 'L', TechRebornAPI.recipeCompact.getItem("lapotronCrystal"),
		// 'T', TechRebornAPI.recipeCompact.getItem("teleporter"));

		CraftingHelper.addShapedOreRecipe(new ItemStack(ModBlocks.Dragoneggenergysiphoner), "CTC", "ISI", "CBC", 'I',
				TechRebornAPI.recipeCompact.getItem("iridiumPlate"), 'C', ItemParts.getPartByName("electronicCircuit"),
				'B', ModItems.lithiumBattery, 'S', ModBlocks.Supercondensator, 'T', ModBlocks.Extractor);

		CraftingHelper.addShapedOreRecipe(new ItemStack(ModBlocks.centrifuge), "SCS", "BEB", "SCS", 'S', "plateSteel",
				'C', "circuitAdvanced", 'B', TechRebornAPI.recipeCompact.getItem("advancedMachine"), 'E',
				TechRebornAPI.recipeCompact.getItem("extractor"));

		CraftingHelper.addShapedOreRecipe(new ItemStack(ModBlocks.BlastFurnace), "CHC", "HBH", "FHF", 'H',
				new ItemStack(ModItems.parts, 1, 17), 'C', ItemParts.getPartByName("advancedCircuit"), 'B',
				BlockMachineFrame.getFrameByName("advancedMachine", 1), 'F', ModBlocks.ElectricFurnace);

		CraftingHelper.addShapedOreRecipe(new ItemStack(ModBlocks.IndustrialGrinder), "ECP", "GGG", "CBC", 'E',
				ModBlocks.IndustrialElectrolyzer, 'P', ModBlocks.Extractor, 'C',
				ItemParts.getPartByName("advancedCircuit"), 'B', TechRebornAPI.recipeCompact.getItem("advancedMachine"),
				'G', ModBlocks.Grinder);

		CraftingHelper.addShapedOreRecipe(new ItemStack(ModBlocks.ImplosionCompressor), "ABA", "CPC", "ABA", 'A',
				ItemParts.getPartByName("advancedAlloy"), 'C', ItemParts.getPartByName("advancedCircuit"), 'B',
				BlockMachineFrame.getFrameByName("advancedMachine", 1), 'P', ModBlocks.Compressor);

		CraftingHelper.addShapedOreRecipe(new ItemStack(ModBlocks.VacuumFreezer), "SPS", "CGC", "SPS", 'S',
				"plateSteel", 'C', ItemParts.getPartByName("advancedCircuit"), 'G', ModBlocks.reinforcedglass, 'P',
				ModBlocks.Extractor);

		CraftingHelper.addShapedOreRecipe(new ItemStack(ModBlocks.Distillationtower), "CMC", "PBP", "EME", 'E',
				ModBlocks.IndustrialElectrolyzer, 'M', "circuitMaster", 'B',
				TechRebornAPI.recipeCompact.getItem("advancedMachine"), 'C', ModBlocks.centrifuge, 'P',
				ModBlocks.Extractor);

		CraftingHelper.addShapedOreRecipe(new ItemStack(ModBlocks.AlloyFurnace), "III", "F F", "III", 'I',
				ItemIngots.getIngotByName("refinediron"), 'F', new ItemStack(ModBlocks.ironFurnace));

		CraftingHelper.addShapedOreRecipe(new ItemStack(ModBlocks.ChemicalReactor), "IMI", "CPC", "IEI", 'I',
				"ingotInvar", 'C', ItemParts.getPartByName("advancedCircuit"), 'M', ModBlocks.Extractor, 'P',
				ModBlocks.Compressor, 'E', ModBlocks.Extractor);

		CraftingHelper.addShapedOreRecipe(new ItemStack(ModBlocks.RollingMachine), "PCP", "MBM", "PCP", 'P',
				Blocks.piston, 'C', ItemParts.getPartByName("advancedCircuit"), 'M', ModBlocks.Compressor, 'B',
				BlockMachineFrame.getFrameByName("machine", 1));

		// CraftingHelper.addShapedOreRecipe(new
		// ItemStack(ModBlocks.ElectricCraftingTable),
		// "ITI", "IBI", "ICI",
		// 'I', "plateIron",
		// 'C', "circuitAdvanced",
		// 'T', "crafterWood",
		// 'B', TechRebornAPI.recipeCompact.getItem("machine"));

		// CraftingHelper.addShapedOreRecipe(new
		// ItemStack(ModBlocks.ElectricCraftingTable),
		// "ATA", "ABA", "ACA",
		// 'A', "plateAluminum",
		// 'C', "circuitAdvanced",
		// 'T', "crafterWood",
		// 'B', TechRebornAPI.recipeCompact.getItem("machine"));

		// CraftingHelper.addShapedOreRecipe(new
		// ItemStack(ModBlocks.ChunkLoader),
		// "SCS", "CMC", "SCS",
		// 'S', "plateSteel",
		// 'C', "circuitMaster",
		// 'M', new ItemStack(ModItems.parts, 1, 39));

		CraftingHelper.addShapedOreRecipe(new ItemStack(ModBlocks.Lesu), " L ", "CBC", " M ", 'L', ModBlocks.lvt, 'C',
				ItemParts.getPartByName("advancedCircuit"), 'M', ModBlocks.mvt, 'B', ModBlocks.LesuStorage);

		CraftingHelper.addShapedOreRecipe(BlockMachineFrame.getFrameByName("highlyAdvancedMachine", 1), "CTC", "TBT",
				"CTC", 'C', "ingotChrome", 'T', "ingotTitanium", 'B',
				TechRebornAPI.recipeCompact.getItem("advancedMachine"));

		CraftingHelper.addShapedOreRecipe(new ItemStack(ModBlocks.MachineCasing, 4, 0), "III", "CBC", "III", 'I',
				"plateIron", 'C', "circuitBasic", 'B', TechRebornAPI.recipeCompact.getItem("machine"));

		CraftingHelper.addShapedOreRecipe(new ItemStack(ModBlocks.MachineCasing, 4, 1), "SSS", "CBC", "SSS", 'S',
				"plateSteel", 'C', "circuitAdvanced", 'B', TechRebornAPI.recipeCompact.getItem("advancedMachine"));

		CraftingHelper.addShapedOreRecipe(new ItemStack(ModBlocks.MachineCasing, 4, 2), "HHH", "CBC", "HHH", 'H',
				"ingotChrome", 'C', "circuitElite", 'B', BlockMachineFrame.getFrameByName("highlyAdvancedMachine", 1));

		CraftingHelper.addShapedOreRecipe(new ItemStack(ModBlocks.quantumChest), "DCD", "ATA", "DQD", 'D',
				ItemParts.getPartByName("dataOrb"), 'C', ItemParts.getPartByName("computerMonitor"), 'A',
				BlockMachineFrame.getFrameByName("highlyAdvancedMachine", 1), 'Q', ModBlocks.digitalChest, 'T',
				ModBlocks.Compressor);

		CraftingHelper.addShapedOreRecipe(new ItemStack(ModBlocks.PlasmaGenerator), "PPP", "PTP", "CGC", 'P',
				ItemPlates.getPlateByName("tungstensteel"), 'T', TechRebornAPI.recipeCompact.getItem("hvTransformer"),
				'G', TechRebornAPI.recipeCompact.getItem("generator"), 'C',
				ItemParts.getPartByName("energyFlowCircuit"));

		// Smetling
		GameRegistry.addSmelting(ItemDusts.getDustByName("copper", 1),
				TechRebornAPI.recipeCompact.getItem("copperIngot"), 1F);
		GameRegistry.addSmelting(ItemDusts.getDustByName("tin", 1), TechRebornAPI.recipeCompact.getItem("tinIngot"),
				1F);
		GameRegistry.addSmelting(ItemDusts.getDustByName("bronze", 1),
				TechRebornAPI.recipeCompact.getItem("bronzeIngot"), 1F);
		GameRegistry.addSmelting(ItemDusts.getDustByName("lead", 1), TechRebornAPI.recipeCompact.getItem("leadIngot"),
				1F);
		GameRegistry.addSmelting(ItemDusts.getDustByName("silver", 1),
				TechRebornAPI.recipeCompact.getItem("silverIngot"), 1F);

		// Saw mill
		ItemStack pulpStack = OreDictionary.getOres("pulpWood").get(0);
		RecipeHandler.addRecipe(new IndustrialSawmillRecipe(new ItemStack(Blocks.log, 1, 0),
				TechRebornAPI.recipeCompact.getItem("waterCell"), null, new ItemStack(Blocks.planks, 6, 0), pulpStack,
				ItemCells.getCellByName("empty"), 200, 30, false));
		RecipeHandler.addRecipe(new IndustrialSawmillRecipe(new ItemStack(Blocks.log, 1, 0),
				TechRebornAPI.recipeCompact.getItem("waterCell"), null, new ItemStack(Blocks.planks, 6, 0), pulpStack,
				ItemCells.getCellByName("empty"), 200, 30, false));
		RecipeHandler.addRecipe(new IndustrialSawmillRecipe(new ItemStack(Blocks.log, 1, 2),
				TechRebornAPI.recipeCompact.getItem("waterCell"), null, new ItemStack(Blocks.planks, 6, 2), pulpStack,
				ItemCells.getCellByName("empty"), 200, 30, false));
		RecipeHandler.addRecipe(new IndustrialSawmillRecipe(new ItemStack(Blocks.log, 1, 3),
				TechRebornAPI.recipeCompact.getItem("waterCell"), null, new ItemStack(Blocks.planks, 6, 3), pulpStack,
				ItemCells.getCellByName("empty"), 200, 30, false));
		RecipeHandler.addRecipe(new IndustrialSawmillRecipe(new ItemStack(Blocks.log2, 1, 0),
				TechRebornAPI.recipeCompact.getItem("waterCell"), null, new ItemStack(Blocks.planks, 6, 4), pulpStack,
				ItemCells.getCellByName("empty"), 200, 30, false));
		RecipeHandler.addRecipe(new IndustrialSawmillRecipe(new ItemStack(Blocks.log2, 1, 1),
				TechRebornAPI.recipeCompact.getItem("waterCell"), null, new ItemStack(Blocks.planks, 6, 5), pulpStack,
				ItemCells.getCellByName("empty"), 200, 30, false));

		// UU
		if (ConfigTechReborn.UUrecipesIridiamOre)
			CraftingHelper.addShapedOreRecipe((TechRebornAPI.recipeCompact.getItem("iridiumOre")), "UUU", " U ", "UUU",
					'U', ModItems.uuMatter);

		// Blast Furnace
		RecipeHandler.addRecipe(new BlastFurnaceRecipe(ItemCells.getCellByName("silicon", 2), null,
				ItemPlates.getPlateByName("silicon"), ItemCells.getCellByName("empty", 2), 1000, 120, 1500));

		// CentrifugeRecipes

		// Plantball/Bio Chaff
		// FIX with ic2
		// RecipeHandler.addRecipe(new CentrifugeRecipe(new
		// ItemStack(Blocks.grass, 16), null, new
		// ItemStack(TechRebornAPI.recipeCompact.getItem("biochaff").getItem(),
		// 8), new
		// ItemStack(TechRebornAPI.recipeCompact.getItem("plantBall").getItem(),
		// 8), new ItemStack(Items.clay_ball), new ItemStack(Blocks.sand, 8),
		// 2500, 5));
		// RecipeHandler.addRecipe(new CentrifugeRecipe(new
		// ItemStack(Blocks.dirt, 16), null, new
		// ItemStack(TechRebornAPI.recipeCompact.getItem("biochaff").getItem(),
		// 4), new
		// ItemStack(TechRebornAPI.recipeCompact.getItem("plantBall").getItem(),
		// 4), new ItemStack(Items.clay_ball), new ItemStack(Blocks.sand, 8),
		// 2500, 5));

		// Methane
		RecipeHandler.addRecipe(new CentrifugeRecipe(new ItemStack(Items.mushroom_stew, 16),
				ItemCells.getCellByName("empty"), ItemCells.getCellByName("methane", 1), null, null, null, 5000, 5));
		RecipeHandler.addRecipe(new CentrifugeRecipe(new ItemStack(Items.apple, 32), ItemCells.getCellByName("empty"),
				ItemCells.getCellByName("methane", 1), null, null, null, 5000, 5));
		RecipeHandler.addRecipe(new CentrifugeRecipe(new ItemStack(Items.porkchop, 12),
				ItemCells.getCellByName("empty"), ItemCells.getCellByName("methane", 1), null, null, null, 5000, 5));
		RecipeHandler.addRecipe(new CentrifugeRecipe(new ItemStack(Items.cooked_porkchop, 16),
				ItemCells.getCellByName("empty"), ItemCells.getCellByName("methane", 1), null, null, null, 5000, 5));
		RecipeHandler.addRecipe(new CentrifugeRecipe(new ItemStack(Items.bread, 64), ItemCells.getCellByName("empty"),
				ItemCells.getCellByName("methane", 1), null, null, null, 5000, 5));
		RecipeHandler.addRecipe(new CentrifugeRecipe(new ItemStack(Items.fish, 12), ItemCells.getCellByName("empty"),
				ItemCells.getCellByName("methane", 1), null, null, null, 5000, 5));
		RecipeHandler.addRecipe(new CentrifugeRecipe(new ItemStack(Items.cooked_fish, 16),
				ItemCells.getCellByName("empty"), ItemCells.getCellByName("methane", 1), null, null, null, 5000, 5));
		RecipeHandler.addRecipe(new CentrifugeRecipe(new ItemStack(Items.beef, 12), ItemCells.getCellByName("empty"),
				ItemCells.getCellByName("methane", 1), null, null, null, 5000, 5));
		RecipeHandler.addRecipe(new CentrifugeRecipe(new ItemStack(Items.cooked_beef, 16),
				ItemCells.getCellByName("empty"), ItemCells.getCellByName("methane", 1), null, null, null, 5000, 5));
		RecipeHandler.addRecipe(new CentrifugeRecipe(new ItemStack(Blocks.pumpkin, 16),
				ItemCells.getCellByName("empty"), ItemCells.getCellByName("methane", 1), null, null, null, 5000, 5));
		RecipeHandler.addRecipe(new CentrifugeRecipe(new ItemStack(Items.speckled_melon, 1),
				ItemCells.getCellByName("empty"), ItemCells.getCellByName("methane", 1),
				new ItemStack(Items.gold_nugget, 6), null, null, 5000, 5));
		RecipeHandler.addRecipe(new CentrifugeRecipe(new ItemStack(Items.spider_eye, 32),
				ItemCells.getCellByName("empty"), ItemCells.getCellByName("methane", 1), null, null, null, 5000, 5));
		RecipeHandler.addRecipe(new CentrifugeRecipe(new ItemStack(Items.chicken, 12), ItemCells.getCellByName("empty"),
				ItemCells.getCellByName("methane", 1), null, null, null, 5000, 5));
		RecipeHandler.addRecipe(new CentrifugeRecipe(new ItemStack(Items.cooked_chicken, 16),
				ItemCells.getCellByName("empty"), ItemCells.getCellByName("methane", 1), null, null, null, 5000, 5));
		RecipeHandler.addRecipe(new CentrifugeRecipe(new ItemStack(Items.rotten_flesh, 16),
				ItemCells.getCellByName("empty"), ItemCells.getCellByName("methane", 1), null, null, null, 5000, 5));
		RecipeHandler.addRecipe(new CentrifugeRecipe(new ItemStack(Items.melon, 64), ItemCells.getCellByName("empty"),
				ItemCells.getCellByName("methane", 1), null, null, null, 5000, 5));
		RecipeHandler.addRecipe(new CentrifugeRecipe(new ItemStack(Items.cookie, 64), ItemCells.getCellByName("empty"),
				ItemCells.getCellByName("methane", 1), null, null, null, 5000, 5));
		RecipeHandler.addRecipe(new CentrifugeRecipe(new ItemStack(Items.cake, 8), ItemCells.getCellByName("empty"),
				ItemCells.getCellByName("methane", 1), null, null, null, 5000, 5));
		RecipeHandler.addRecipe(new CentrifugeRecipe(new ItemStack(Items.golden_carrot, 1),
				ItemCells.getCellByName("empty"), ItemCells.getCellByName("methane", 1),
				new ItemStack(Items.gold_nugget, 6), null, null, 5000, 5));
		RecipeHandler.addRecipe(new CentrifugeRecipe(new ItemStack(Items.carrot, 16), ItemCells.getCellByName("empty"),
				ItemCells.getCellByName("methane", 1), null, null, null, 5000, 5));
		RecipeHandler.addRecipe(new CentrifugeRecipe(new ItemStack(Items.baked_potato, 24),
				ItemCells.getCellByName("empty"), ItemCells.getCellByName("methane", 1), null, null, null, 5000, 5));
		RecipeHandler.addRecipe(new CentrifugeRecipe(new ItemStack(Items.potato, 16), ItemCells.getCellByName("empty"),
				ItemCells.getCellByName("methane", 1), null, null, null, 5000, 5));
		RecipeHandler.addRecipe(new CentrifugeRecipe(new ItemStack(Items.poisonous_potato, 12),
				ItemCells.getCellByName("empty"), ItemCells.getCellByName("methane", 1), null, null, null, 5000, 5));
		RecipeHandler.addRecipe(new CentrifugeRecipe(new ItemStack(Items.nether_wart, 1),
				ItemCells.getCellByName("empty"), ItemCells.getCellByName("methane", 1), null, null, null, 5000, 5));
		// Fix with ic2
		// RecipeHandler.addRecipe(new CentrifugeRecipe(new
		// ItemStack(TechRebornAPI.recipeCompact.getItem("terraWart").getItem(),
		// 16), ItemCells.getCellByName("empty"),
		// ItemCells.getCellByName("methane", 1), null, null, null, 5000, 5));
		RecipeHandler.addRecipe(new CentrifugeRecipe(new ItemStack(Blocks.brown_mushroom, 1),
				ItemCells.getCellByName("empty"), ItemCells.getCellByName("methane", 1), null, null, null, 5000, 5));
		RecipeHandler.addRecipe(new CentrifugeRecipe(new ItemStack(Blocks.red_mushroom, 1),
				ItemCells.getCellByName("empty"), ItemCells.getCellByName("methane", 1), null, null, null, 5000, 5));

		// Rubber Wood Yields
		RecipeHandler.addRecipe(
				new CentrifugeRecipe(new ItemStack(TechRebornAPI.recipeCompact.getItem("rubberWood").getItem(), 16),
						ItemCells.getCellByName("empty", 5), new ItemStack(ModItems.parts, 8, 41),
						new ItemStack(Blocks.sapling, 6), ItemCells.getCellByName("methane", 1),
						ItemCells.getCellByName("carbon", 4), 5000, 5, false));

		// Soul Sand Byproducts
		RecipeHandler
				.addRecipe(new CentrifugeRecipe(new ItemStack(Blocks.soul_sand, 16), ItemCells.getCellByName("empty"),
						ItemCells.getCellByName("oil", 1), ItemDusts.getDustByName("saltpeter", 4),
						ItemDusts.getDustByName("coal", 1), new ItemStack(Blocks.sand, 10), 2500, 5));

		// Ice
		RecipeHandler.addRecipe(new CentrifugeRecipe(ItemCells.getCellByName("ice", 1), null,
				new ItemStack(Blocks.ice, 1), ItemCells.getCellByName("empty"), null, null, 40, 5));

		// Dust Byproducts

		RecipeHandler.addRecipe(new CentrifugeRecipe(new ItemStack(Items.glowstone_dust, 16),
				ItemCells.getCellByName("empty"), new ItemStack(Items.redstone, 8), ItemDusts.getDustByName("gold", 8),
				ItemCells.getCellByName("helium", 1), null, 25000, 5));
		RecipeHandler.addRecipe(new CentrifugeRecipe(ItemDusts.getDustByName("phosphorous", 5),
				ItemCells.getCellByName("empty", 3), ItemCells.getCellByName("calcium", 3), null, null, null, 1280, 5));
		RecipeHandler.addRecipe(new CentrifugeRecipe(ItemDusts.getDustByName("ashes", 1),
				ItemCells.getCellByName("empty"), ItemCells.getCellByName("carbon"), null, null, null, 80, 5));
		RecipeHandler
				.addRecipe(new CentrifugeRecipe(new ItemStack(Items.redstone, 10), ItemCells.getCellByName("empty", 4),
						ItemCells.getCellByName("silicon", 1), ItemDusts.getDustByName("pyrite", 3),
						ItemDusts.getDustByName("ruby", 1), ItemCells.getCellByName("mercury", 3), 6800, 5));
		RecipeHandler.addRecipe(
				new CentrifugeRecipe(ItemDusts.getDustByName("endstone", 16), ItemCells.getCellByName("empty", 2),
						ItemCells.getCellByName("helium3", 1), ItemCells.getCellByName("helium"),
						ItemDustsSmall.getSmallDustByName("Tungsten", 1), new ItemStack(Blocks.sand, 12), 4800, 5));
		RecipeHandler.addRecipe(new CentrifugeRecipe(ItemDusts.getDustByName("cinnabar", 2),
				ItemCells.getCellByName("empty"), ItemCells.getCellByName("mercury", 1),
				ItemDusts.getDustByName("sulfur", 1), null, null, 80, 5));
		RecipeHandler.addRecipe(new CentrifugeRecipe(ItemDusts.getDustByName("flint", 1), null,
				TechRebornAPI.recipeCompact.getItem("silicondioxideDust"), null, null, null, 160, 5));

		// Deuterium/Tritium
		RecipeHandler.addRecipe(new CentrifugeRecipe(ItemCells.getCellByName("helium", 16), null,
				ItemCells.getCellByName("deuterium", 1), ItemCells.getCellByName("empty", 15), null, null, 10000, 5));
		RecipeHandler.addRecipe(new CentrifugeRecipe(ItemCells.getCellByName("deuterium", 4), null,
				ItemCells.getCellByName("tritium", 1), ItemCells.getCellByName("empty", 3), null, null, 3000, 5));
		RecipeHandler.addRecipe(new CentrifugeRecipe(ItemCells.getCellByName("hydrogen", 4), null,
				ItemCells.getCellByName("deuterium", 1), ItemCells.getCellByName("empty", 3), null, null, 3000, 5));

		// Lava Cell Byproducts
		ItemStack lavaCells = TechRebornAPI.recipeCompact.getItem("lavaCell");
		lavaCells.stackSize = 8;
		RecipeHandler.addRecipe(new CentrifugeRecipe(lavaCells, null, ItemNuggets.getNuggetByName("electrum", 4),
				ItemIngots.getIngotByName("copper", 2), ItemDustsSmall.getSmallDustByName("Tungsten", 1),
				ItemIngots.getIngotByName("tin", 2), 6000, 5));

		// IndustrialGrinderRecipes
		RecipeHandler.addRecipe(new IndustrialGrinderRecipe(new ItemStack(Blocks.coal_ore, 1),
				TechRebornAPI.recipeCompact.getItem("waterCell"), null, new ItemStack(Items.coal, 1),
				ItemDustsSmall.getSmallDustByName("Coal", 6), ItemDustsSmall.getSmallDustByName("Coal", 2),
				ItemCells.getCellByName("empty"), 100, 120));
		RecipeHandler.addRecipe(new IndustrialGrinderRecipe(new ItemStack(Blocks.iron_ore, 1),
				TechRebornAPI.recipeCompact.getItem("waterCell"), null, ItemDusts.getDustByName("iron", 2),
				ItemDustsSmall.getSmallDustByName("Nickel", 1), ItemDustsSmall.getSmallDustByName("Tin", 1),
				ItemCells.getCellByName("empty"), 100, 120));
		RecipeHandler.addRecipe(new IndustrialGrinderRecipe(new ItemStack(Blocks.gold_ore, 1),
				TechRebornAPI.recipeCompact.getItem("waterCell"), null, ItemDusts.getDustByName("gold", 2),
				ItemDustsSmall.getSmallDustByName("Copper", 1), ItemDustsSmall.getSmallDustByName("Nickel", 1),
				ItemCells.getCellByName("empty"), 100, 120));
		RecipeHandler.addRecipe(new IndustrialGrinderRecipe(new ItemStack(Blocks.iron_ore, 1),
				ItemCells.getCellByName("sodiumPersulfate", 1), null, ItemDusts.getDustByName("iron", 2),
				ItemDusts.getDustByName("nickel", 1), ItemDustsSmall.getSmallDustByName("Tin", 1),
				ItemCells.getCellByName("empty"), 100, 120));
		RecipeHandler.addRecipe(new IndustrialGrinderRecipe(new ItemStack(Blocks.gold_ore, 1),
				ItemCells.getCellByName("sodiumPersulfate", 1), null, ItemDusts.getDustByName("gold", 2),
				ItemDusts.getDustByName("copper", 1), ItemDustsSmall.getSmallDustByName("Nickel", 1),
				ItemCells.getCellByName("empty"), 100, 120));
		RecipeHandler.addRecipe(
				new IndustrialGrinderRecipe(new ItemStack(Blocks.gold_ore, 1), ItemCells.getCellByName("mercury", 1),
						null, ItemDusts.getDustByName("gold", 3), ItemDustsSmall.getSmallDustByName("Copper", 1),
						ItemDustsSmall.getSmallDustByName("Nickel", 1), ItemCells.getCellByName("empty"), 100, 120));
		RecipeHandler.addRecipe(new IndustrialGrinderRecipe(new ItemStack(Blocks.diamond_ore, 1),
				TechRebornAPI.recipeCompact.getItem("waterCell"), null, new ItemStack(Items.diamond, 1),
				ItemDustsSmall.getSmallDustByName("Diamond", 6), ItemDustsSmall.getSmallDustByName("Coal", 2),
				ItemCells.getCellByName("empty"), 100, 120));
		RecipeHandler.addRecipe(new IndustrialGrinderRecipe(new ItemStack(Blocks.emerald_ore, 1),
				TechRebornAPI.recipeCompact.getItem("waterCell"), null, new ItemStack(Items.emerald, 1),
				ItemDustsSmall.getSmallDustByName("Emerald", 6), ItemDustsSmall.getSmallDustByName("Aluminum", 2),
				ItemCells.getCellByName("empty"), 100, 120));
		RecipeHandler.addRecipe(new IndustrialGrinderRecipe(new ItemStack(Blocks.redstone_ore, 1),
				TechRebornAPI.recipeCompact.getItem("waterCell"), null, new ItemStack(Items.redstone, 10),
				ItemDustsSmall.getSmallDustByName("Cinnabar", 1), ItemDustsSmall.getSmallDustByName("Glowstone", 1),
				ItemCells.getCellByName("empty"), 100, 120));
		RecipeHandler.addRecipe(new IndustrialGrinderRecipe(new ItemStack(Blocks.lapis_ore, 1),
				TechRebornAPI.recipeCompact.getItem("waterCell"), null, new ItemStack(Items.dye, 6, 4),
				ItemDustsSmall.getSmallDustByName("Lapis", 36), ItemDustsSmall.getSmallDustByName("Lazurite", 8),
				ItemCells.getCellByName("empty"), 100, 120));

		// Copper Ore
		if (OreUtil.doesOreExistAndValid("oreCopper")) {
			try {
				ItemStack oreStack = OreDictionary.getOres("oreCopper").get(0);
				RecipeHandler.addRecipe(new IndustrialGrinderRecipe(oreStack,
						TechRebornAPI.recipeCompact.getItem("waterCell"), null, ItemDusts.getDustByName("copper", 2),
						ItemDustsSmall.getSmallDustByName("Gold", 1), ItemDustsSmall.getSmallDustByName("Nickel", 1),
						ItemCells.getCellByName("empty"), 100, 120));

				RecipeHandler.addRecipe(new IndustrialGrinderRecipe(oreStack,
						ItemCells.getCellByName("sodiumPersulfate", 1), null, ItemDusts.getDustByName("copper", 2),
						ItemDusts.getDustByName("gold", 1), ItemDustsSmall.getSmallDustByName("Nickel", 1),
						ItemCells.getCellByName("empty"), 100, 120));

				RecipeHandler.addRecipe(new IndustrialGrinderRecipe(oreStack, ItemCells.getCellByName("mercury", 1),
						null, ItemDusts.getDustByName("copper", 2), ItemDustsSmall.getSmallDustByName("Gold", 1),
						ItemDusts.getDustByName("nickel", 1), ItemCells.getCellByName("empty"), 100, 120));
			} catch (Exception e) {
				Core.logHelper.info("Failed to Load Grinder Recipe for Copper Ore");
			}
		}

		// Tin Ore
		if (OreUtil.doesOreExistAndValid("oreTin")) {
			try {
				ItemStack oreStack = OreDictionary.getOres("oreTin").get(0);
				RecipeHandler.addRecipe(new IndustrialGrinderRecipe(oreStack,
						TechRebornAPI.recipeCompact.getItem("waterCell"), null, ItemDusts.getDustByName("tin", 2),
						ItemDustsSmall.getSmallDustByName("Iron", 1), ItemDustsSmall.getSmallDustByName("Zinc", 1),
						ItemCells.getCellByName("empty"), 100, 120));
				RecipeHandler
						.addRecipe(new IndustrialGrinderRecipe(oreStack, ItemCells.getCellByName("sodiumPersulfate", 1),
								null, ItemDusts.getDustByName("tin", 2), ItemDustsSmall.getSmallDustByName("Iron", 1),
								ItemDusts.getDustByName("zinc", 1), ItemCells.getCellByName("empty"), 100, 120));
			} catch (Exception e) {
				Core.logHelper.info("Failed to Load Grinder Recipe for Tin Ore");
			}
		}

		// Nickel Ore
		if (OreUtil.doesOreExistAndValid("oreNickel")) {
			try {
				ItemStack oreStack = OreDictionary.getOres("oreNickel").get(0);
				RecipeHandler.addRecipe(new IndustrialGrinderRecipe(oreStack,
						TechRebornAPI.recipeCompact.getItem("waterCell"), null, ItemDusts.getDustByName("nickel", 2),
						ItemDustsSmall.getSmallDustByName("Iron", 1), ItemDustsSmall.getSmallDustByName("Platinum", 1),
						ItemCells.getCellByName("empty"), 100, 120));
				RecipeHandler.addRecipe(new IndustrialGrinderRecipe(oreStack,
						ItemCells.getCellByName("sodiumPersulfate", 1), null, ItemDusts.getDustByName("nickel", 3),
						ItemDustsSmall.getSmallDustByName("Iron", 1), ItemDustsSmall.getSmallDustByName("Platinum", 1),
						ItemCells.getCellByName("empty"), 100, 120));
				RecipeHandler.addRecipe(new IndustrialGrinderRecipe(oreStack, ItemCells.getCellByName("mercury", 1),
						null, ItemDusts.getDustByName("nickel", 2), ItemDustsSmall.getSmallDustByName("Iron", 1),
						ItemDusts.getDustByName("platinum", 1), ItemCells.getCellByName("empty"), 100, 120));
			} catch (Exception e) {
				Core.logHelper.info("Failed to Load Grinder Recipe for Nickel Ore");
			}
		}

		// Zinc Ore
		if (OreUtil.doesOreExistAndValid("oreZinc")) {
			try {
				ItemStack oreStack = OreDictionary.getOres("oreZinc").get(0);
				RecipeHandler.addRecipe(new IndustrialGrinderRecipe(oreStack,
						TechRebornAPI.recipeCompact.getItem("waterCell"), null, ItemDusts.getDustByName("zinc", 2),
						ItemDustsSmall.getSmallDustByName("Iron", 1), ItemDustsSmall.getSmallDustByName("Tin", 1),
						ItemCells.getCellByName("empty"), 100, 120));
				RecipeHandler
						.addRecipe(new IndustrialGrinderRecipe(oreStack, ItemCells.getCellByName("sodiumPersulfate", 1),
								null, ItemDusts.getDustByName("zinc", 2), ItemDustsSmall.getSmallDustByName("Iron", 1),
								ItemDusts.getDustByName("iron", 1), ItemCells.getCellByName("empty"), 100, 120));
			} catch (Exception e) {
				Core.logHelper.info("Failed to Load Grinder Recipe for Zinc Ore");
			}
		}

		// Silver Ore
		if (OreUtil.doesOreExistAndValid("oreSilver")) {
			try {
				ItemStack oreStack = OreDictionary.getOres("oreSilver").get(0);
				RecipeHandler.addRecipe(new IndustrialGrinderRecipe(oreStack,
						TechRebornAPI.recipeCompact.getItem("waterCell"), null, ItemDusts.getDustByName("silver", 2),
						ItemDustsSmall.getSmallDustByName("Lead", 1), ItemDustsSmall.getSmallDustByName("Sulfur", 1),
						ItemCells.getCellByName("empty"), 100, 120));
				RecipeHandler.addRecipe(new IndustrialGrinderRecipe(oreStack, ItemCells.getCellByName("mercury", 1),
						null, ItemDusts.getDustByName("silver", 3), ItemDustsSmall.getSmallDustByName("Lead", 1),
						ItemDustsSmall.getSmallDustByName("Sulfur", 1), ItemCells.getCellByName("empty"), 100, 120));
			} catch (Exception e) {
				Core.logHelper.info("Failed to Load Grinder Recipe for Silver Ore");
			}
		}

		// Lead Ore
		if (OreUtil.doesOreExistAndValid("oreLead")) {
			try {
				ItemStack oreStack = OreDictionary.getOres("oreLead").get(0);
				RecipeHandler.addRecipe(new IndustrialGrinderRecipe(oreStack,
						TechRebornAPI.recipeCompact.getItem("waterCell"), null, ItemDusts.getDustByName("lead", 2),
						ItemDustsSmall.getSmallDustByName("Silver", 1), ItemDustsSmall.getSmallDustByName("Sulfur", 1),
						ItemCells.getCellByName("empty"), 100, 120));
				RecipeHandler.addRecipe(new IndustrialGrinderRecipe(oreStack, ItemCells.getCellByName("mercury", 1),
						null, ItemDusts.getDustByName("lead", 2), ItemDusts.getDustByName("silver", 1),
						ItemDustsSmall.getSmallDustByName("Sulfur", 1), ItemCells.getCellByName("empty"), 100, 120));
			} catch (Exception e) {
				Core.logHelper.info("Failed to Load Grinder Recipe for Lead Ore");
			}
		}

		// Uranium Ore
		if (OreUtil.doesOreExistAndValid("oreUranium")) {
			try {
				ItemStack oreStack = OreDictionary.getOres("oreUranium").get(0);
				ItemStack uranium238Stack = TechRebornAPI.recipeCompact.getItem("Uran238");
				uranium238Stack.stackSize = 8;
				ItemStack uranium235Stack = TechRebornAPI.recipeCompact.getItem("smallUran235");
				uranium235Stack.stackSize = 2;
				RecipeHandler.addRecipe(
						new IndustrialGrinderRecipe(oreStack, null, new FluidStack(FluidRegistry.WATER, 1000),
								uranium238Stack, uranium235Stack, null, null, 100, 120));
				RecipeHandler.addRecipe(
						new IndustrialGrinderRecipe(oreStack, TechRebornAPI.recipeCompact.getItem("waterCell"), null,
								uranium238Stack, uranium235Stack, null, ItemCells.getCellByName("empty"), 100, 120));
				RecipeHandler.addRecipe(new IndustrialGrinderRecipe(oreStack, new ItemStack(Items.water_bucket), null,
						uranium238Stack, uranium235Stack, null, new ItemStack(Items.bucket), 100, 120));
			} catch (Exception e) {
				Core.logHelper.info("Failed to Load Grinder Recipe for Uranium Ore");
			}
		}

		// Pitchblende Ore
		if (OreUtil.doesOreExistAndValid("orePitchblende")) {
			try {
				ItemStack oreStack = OreDictionary.getOres("orePitchblende").get(0);
				ItemStack uranium238Stack = TechRebornAPI.recipeCompact.getItem("Uran238");
				uranium238Stack.stackSize = 8;
				ItemStack uranium235Stack = TechRebornAPI.recipeCompact.getItem("smallUran235");
				uranium235Stack.stackSize = 2;
				RecipeHandler.addRecipe(
						new IndustrialGrinderRecipe(oreStack, null, new FluidStack(FluidRegistry.WATER, 1000),
								uranium238Stack, uranium235Stack, null, null, 100, 120));
				RecipeHandler.addRecipe(
						new IndustrialGrinderRecipe(oreStack, TechRebornAPI.recipeCompact.getItem("waterCell"), null,
								uranium238Stack, uranium235Stack, null, ItemCells.getCellByName("empty"), 100, 120));
				RecipeHandler.addRecipe(new IndustrialGrinderRecipe(oreStack, new ItemStack(Items.water_bucket), null,
						uranium238Stack, uranium235Stack, null, new ItemStack(Items.bucket), 100, 120));
			} catch (Exception e) {
				Core.logHelper.info("Failed to Load Grinder Recipe for Uranium Ore");
			}
		}

		// Aluminum Ore
		if (OreUtil.doesOreExistAndValid("oreAluminum")) {
			try {
				ItemStack oreStack = OreDictionary.getOres("oreAluminum").get(0);
				RecipeHandler.addRecipe(new IndustrialGrinderRecipe(oreStack,
						TechRebornAPI.recipeCompact.getItem("waterCell"), null, ItemDusts.getDustByName("aluminum", 2),
						ItemDustsSmall.getSmallDustByName("Bauxite", 1),
						ItemDustsSmall.getSmallDustByName("Bauxite", 1), ItemCells.getCellByName("empty"), 100, 120));
			} catch (Exception e) {
				Core.logHelper.info("Failed to Load Grinder Recipe for Lead Ore");
			}
		}

		// Ardite Ore
		if (OreUtil.doesOreExistAndValid("oreArdite")) {
			try {
				ItemStack oreStack = OreDictionary.getOres("oreArdite").get(0);
				RecipeHandler.addRecipe(new IndustrialGrinderRecipe(oreStack,
						TechRebornAPI.recipeCompact.getItem("waterCell"), null, ItemDusts.getDustByName("ardite", 2),
						ItemDustsSmall.getSmallDustByName("Ardite", 1), ItemDustsSmall.getSmallDustByName("Ardite", 1),
						ItemCells.getCellByName("empty"), 100, 120));
			} catch (Exception e) {
				Core.logHelper.info("Failed to Load Grinder Recipe for Ardite Ore");
			}
		}

		// Cobalt Ore
		if (OreUtil.doesOreExistAndValid("oreCobalt")) {
			try {
				ItemStack oreStack = OreDictionary.getOres("oreCobalt").get(0);
				RecipeHandler.addRecipe(new IndustrialGrinderRecipe(oreStack,
						TechRebornAPI.recipeCompact.getItem("waterCell"), null, ItemDusts.getDustByName("cobalt", 2),
						ItemDustsSmall.getSmallDustByName("Cobalt", 1), ItemDustsSmall.getSmallDustByName("Cobalt", 1),
						ItemCells.getCellByName("empty"), 100, 120));
			} catch (Exception e) {
				Core.logHelper.info("Failed to Load Grinder Recipe for Cobalt Ore");
			}
		}

		// Dark Iron Ore
		if (OreUtil.doesOreExistAndValid("oreDarkIron")) {
			try {
				ItemStack oreStack = OreDictionary.getOres("oreDarkIron").get(0);
				RecipeHandler.addRecipe(new IndustrialGrinderRecipe(oreStack,
						TechRebornAPI.recipeCompact.getItem("waterCell"), null, ItemDusts.getDustByName("darkIron", 2),
						ItemDustsSmall.getSmallDustByName("DarkIron", 1), ItemDustsSmall.getSmallDustByName("Iron", 1),
						ItemCells.getCellByName("empty"), 100, 120));
			} catch (Exception e) {
				Core.logHelper.info("Failed to Load Grinder Recipe for Dark Iron Ore");
			}
		}

		// Cadmium Ore
		if (OreUtil.doesOreExistAndValid("oreCadmium")) {
			try {
				ItemStack oreStack = OreDictionary.getOres("oreCadmium").get(0);
				RecipeHandler.addRecipe(new IndustrialGrinderRecipe(oreStack,
						TechRebornAPI.recipeCompact.getItem("waterCell"), null, ItemDusts.getDustByName("cadmium", 2),
						ItemDustsSmall.getSmallDustByName("Cadmium", 1),
						ItemDustsSmall.getSmallDustByName("Cadmium", 1), ItemCells.getCellByName("empty"), 100, 120));
			} catch (Exception e) {
				Core.logHelper.info("Failed to Load Grinder Recipe for Cadmium Ore");
			}
		}

		// Indium Ore
		if (OreUtil.doesOreExistAndValid("oreIndium")) {
			try {
				ItemStack oreStack = OreDictionary.getOres("oreIndium").get(0);
				RecipeHandler.addRecipe(new IndustrialGrinderRecipe(oreStack,
						TechRebornAPI.recipeCompact.getItem("waterCell"), null, ItemDusts.getDustByName("indium", 2),
						ItemDustsSmall.getSmallDustByName("Indium", 1), ItemDustsSmall.getSmallDustByName("Indium", 1),
						ItemCells.getCellByName("empty"), 100, 120));
			} catch (Exception e) {
				Core.logHelper.info("Failed to Load Grinder Recipe for Indium Ore");
			}
		}

		// Calcite Ore
		if (OreUtil.doesOreExistAndValid("oreCalcite") && OreUtil.doesOreExistAndValid("gemCalcite")) {
			try {
				ItemStack oreStack = OreDictionary.getOres("oreCalcite").get(0);
				ItemStack gemStack = OreDictionary.getOres("gemCalcite").get(0);
				RecipeHandler.addRecipe(
						new IndustrialGrinderRecipe(oreStack, TechRebornAPI.recipeCompact.getItem("waterCell"), null,
								gemStack, ItemDustsSmall.getSmallDustByName("Calcite", 6), null,
								ItemCells.getCellByName("empty"), 100, 120));
			} catch (Exception e) {
				Core.logHelper.info("Failed to Load Grinder Recipe for Calcite Ore");
			}
		}

		// Magnetite Ore
		if (OreUtil.doesOreExistAndValid("oreMagnetite") && OreUtil.doesOreExistAndValid("chunkMagnetite")) {
			try {
				ItemStack oreStack = OreDictionary.getOres("oreMagnetite").get(0);
				ItemStack chunkStack = OreDictionary.getOres("chunkMagnetite").get(0);
				RecipeHandler.addRecipe(
						new IndustrialGrinderRecipe(oreStack, TechRebornAPI.recipeCompact.getItem("waterCell"), null,
								chunkStack, ItemDustsSmall.getSmallDustByName("Magnetite", 6), null,
								ItemCells.getCellByName("empty"), 100, 120));
			} catch (Exception e) {
				Core.logHelper.info("Failed to Load Grinder Recipe for Magnetite Ore");
			}
		}

		// Graphite Ore
		if (OreUtil.doesOreExistAndValid("oreGraphite") && OreUtil.doesOreExistAndValid("chunkGraphite")) {
			try {
				ItemStack oreStack = OreDictionary.getOres("oreGraphite").get(0);
				ItemStack chunkStack = OreDictionary.getOres("chunkGraphite").get(0);
				RecipeHandler.addRecipe(
						new IndustrialGrinderRecipe(oreStack, TechRebornAPI.recipeCompact.getItem("waterCell"), null,
								chunkStack, ItemDustsSmall.getSmallDustByName("Graphite", 6), null,
								ItemCells.getCellByName("empty"), 100, 120));
			} catch (Exception e) {
				Core.logHelper.info("Failed to Load Grinder Recipe for Graphite Ore");
			}
		}

		// Osmium Ore
		if (OreUtil.doesOreExistAndValid("oreOsmium")) {
			try {
				ItemStack oreStack = OreDictionary.getOres("oreOsmium").get(0);
				RecipeHandler.addRecipe(new IndustrialGrinderRecipe(oreStack,
						TechRebornAPI.recipeCompact.getItem("waterCell"), null, ItemDusts.getDustByName("osmium", 2),
						ItemDustsSmall.getSmallDustByName("Osmium", 1), ItemDustsSmall.getSmallDustByName("Osmium", 1),
						ItemCells.getCellByName("empty"), 100, 120));
			} catch (Exception e) {
				Core.logHelper.info("Failed to Load Grinder Recipe for Osmium Ore");
			}
		}

		// Teslatite Ore
		if (OreUtil.doesOreExistAndValid("oreTeslatite") && OreUtil.doesOreExistAndValid("dustTeslatite")) {
			try {
				ItemStack oreStack = OreDictionary.getOres("oreTeslatite").get(0);
				ItemStack dustStack = OreDictionary.getOres("dustTeslatite").get(0);
				dustStack.stackSize = 10;
				RecipeHandler.addRecipe(new IndustrialGrinderRecipe(oreStack,
						TechRebornAPI.recipeCompact.getItem("waterCell"), null, dustStack,
						ItemDustsSmall.getSmallDustByName("Sodalite", 1),
						ItemDustsSmall.getSmallDustByName("Glowstone", 1), ItemCells.getCellByName("empty"), 100, 120));
			} catch (Exception e) {
				Core.logHelper.info("Failed to Load Grinder Recipe for Teslatite Ore");
			}
		}

		// Sulfur Ore
		if (OreUtil.doesOreExistAndValid("oreSulfur")) {
			try {
				ItemStack oreStack = OreDictionary.getOres("oreSulfur").get(0);
				RecipeHandler.addRecipe(new IndustrialGrinderRecipe(oreStack,
						TechRebornAPI.recipeCompact.getItem("waterCell"), null, ItemDusts.getDustByName("sulfur", 2),
						ItemDustsSmall.getSmallDustByName("Sulfur", 1), ItemDustsSmall.getSmallDustByName("Sulfur", 1),
						ItemCells.getCellByName("empty"), 100, 120));
			} catch (Exception e) {
				Core.logHelper.info("Failed to Load Grinder Recipe for Sulfur Ore");
			}
		}

		// Saltpeter Ore
		if (OreUtil.doesOreExistAndValid("oreSaltpeter")) {
			try {
				ItemStack oreStack = OreDictionary.getOres("oreSaltpeter").get(0);
				RecipeHandler.addRecipe(new IndustrialGrinderRecipe(oreStack,
						TechRebornAPI.recipeCompact.getItem("waterCell"), null, ItemDusts.getDustByName("saltpeter", 2),
						ItemDustsSmall.getSmallDustByName("Saltpeter", 1),
						ItemDustsSmall.getSmallDustByName("Saltpeter", 1), ItemCells.getCellByName("empty"), 100, 120));
			} catch (Exception e) {
				Core.logHelper.info("Failed to Load Grinder Recipe for Saltpeter Ore");
			}
		}

		// Apatite Ore
		if (OreUtil.doesOreExistAndValid("oreApatite") & OreUtil.doesOreExistAndValid("gemApatite")) {
			try {
				ItemStack oreStack = OreDictionary.getOres("oreApatite").get(0);
				ItemStack gemStack = OreDictionary.getOres("gemApatite").get(0);
				gemStack.stackSize = 6;
				RecipeHandler.addRecipe(
						new IndustrialGrinderRecipe(oreStack, TechRebornAPI.recipeCompact.getItem("waterCell"), null,
								gemStack, gemStack, ItemDustsSmall.getSmallDustByName("Phosphorous", 4),
								ItemCells.getCellByName("empty"), 100, 120));
			} catch (Exception e) {
				Core.logHelper.info("Failed to Load Grinder Recipe for Apatite Ore");
			}
		}

		// Nether Quartz Ore
		if (OreUtil.doesOreExistAndValid("dustNetherQuartz")) {
			try {
				ItemStack dustStack = OreDictionary.getOres("dustNetherQuartz").get(0);
				dustStack.stackSize = 4;
				RecipeHandler.addRecipe(new IndustrialGrinderRecipe(new ItemStack(Blocks.quartz_ore, 1),
						TechRebornAPI.recipeCompact.getItem("waterCell"), null, new ItemStack(Items.quartz, 2),
						dustStack, ItemDustsSmall.getSmallDustByName("Netherrack", 2), ItemCells.getCellByName("empty"),
						100, 120));
			} catch (Exception e) {
				Core.logHelper.info("Failed to Load Grinder Recipe for Nether Quartz Ore");
			}
		}

		// Certus Quartz Ore
		if (OreUtil.doesOreExistAndValid("oreCertusQuartz")) {
			try {
				ItemStack oreStack = OreDictionary.getOres("oreCertusQuartz").get(0);
				ItemStack gemStack = OreDictionary.getOres("crystalCertusQuartz").get(0);
				ItemStack dustStack = OreDictionary.getOres("dustCertusQuartz").get(0);
				dustStack.stackSize = 2;
				RecipeHandler.addRecipe(
						new IndustrialGrinderRecipe(oreStack, TechRebornAPI.recipeCompact.getItem("waterCell"), null,
								gemStack, dustStack, null, ItemCells.getCellByName("empty"), 100, 120));
			} catch (Exception e) {
				Core.logHelper.info("Failed to Load Grinder Recipe for Certus Quartz Ore");
			}
		}

		// Charged Certus Quartz Ore
		if (OreUtil.doesOreExistAndValid("oreChargedCertusQuartz")) {
			try {
				ItemStack oreStack = OreDictionary.getOres("oreChargedCertusQuartz").get(0);
				ItemStack gemStack = OreDictionary.getOres("crystalChargedCertusQuartz").get(0);
				ItemStack dustStack = OreDictionary.getOres("dustCertusQuartz").get(0);
				dustStack.stackSize = 2;
				RecipeHandler.addRecipe(
						new IndustrialGrinderRecipe(oreStack, TechRebornAPI.recipeCompact.getItem("waterCell"), null,
								gemStack, dustStack, null, ItemCells.getCellByName("empty"), 100, 120));
			} catch (Exception e) {
				Core.logHelper.info("Failed to Load Grinder Recipe for Charged Certus Quartz Ore");
			}
		}

		// Amethyst Ore
		if (OreUtil.doesOreExistAndValid("oreAmethyst") && OreUtil.doesOreExistAndValid("gemAmethyst")) {
			try {
				ItemStack oreStack = OreDictionary.getOres("oreAmethyst").get(0);
				ItemStack gemStack = OreDictionary.getOres("gemAmethyst").get(0);
				gemStack.stackSize = 2;
				ItemStack dustStack = OreDictionary.getOres("gemAmethyst").get(0);
				dustStack.stackSize = 1;
				RecipeHandler.addRecipe(
						new IndustrialGrinderRecipe(oreStack, TechRebornAPI.recipeCompact.getItem("waterCell"), null,
								gemStack, dustStack, null, ItemCells.getCellByName("empty"), 100, 120));
			} catch (Exception e) {
				Core.logHelper.info("Failed to Load Grinder Recipe for Certus Quartz Ore");
			}
		}

		// Topaz Ore
		if (OreUtil.doesOreExistAndValid("oreTopaz") && OreUtil.doesOreExistAndValid("gemTopaz")) {
			try {
				ItemStack oreStack = OreDictionary.getOres("oreTopaz").get(0);
				ItemStack gemStack = OreDictionary.getOres("gemTopaz").get(0);
				gemStack.stackSize = 2;
				ItemStack dustStack = OreDictionary.getOres("gemTopaz").get(0);
				dustStack.stackSize = 1;
				RecipeHandler.addRecipe(
						new IndustrialGrinderRecipe(oreStack, TechRebornAPI.recipeCompact.getItem("waterCell"), null,
								gemStack, dustStack, null, ItemCells.getCellByName("empty"), 100, 120));
			} catch (Exception e) {
				Core.logHelper.info("Failed to Load Grinder Recipe for Topaz Ore");
			}
		}

		// Tanzanite Ore
		if (OreUtil.doesOreExistAndValid("oreTanzanite") && OreUtil.doesOreExistAndValid("gemTanzanite")) {
			try {
				ItemStack oreStack = OreDictionary.getOres("oreTanzanite").get(0);
				ItemStack gemStack = OreDictionary.getOres("gemTanzanite").get(0);
				gemStack.stackSize = 2;
				ItemStack dustStack = OreDictionary.getOres("gemTanzanite").get(0);
				dustStack.stackSize = 1;
				RecipeHandler.addRecipe(
						new IndustrialGrinderRecipe(oreStack, TechRebornAPI.recipeCompact.getItem("waterCell"), null,
								gemStack, dustStack, null, ItemCells.getCellByName("empty"), 100, 120));
			} catch (Exception e) {
				Core.logHelper.info("Failed to Load Grinder Recipe for Tanzanite Ore");
			}
		}

		// Malachite Ore
		if (OreUtil.doesOreExistAndValid("oreMalachite") && OreUtil.doesOreExistAndValid("gemMalachite")) {
			try {
				ItemStack oreStack = OreDictionary.getOres("oreMalachite").get(0);
				ItemStack gemStack = OreDictionary.getOres("gemMalachite").get(0);
				gemStack.stackSize = 2;
				ItemStack dustStack = OreDictionary.getOres("gemMalachite").get(0);
				dustStack.stackSize = 1;
				RecipeHandler.addRecipe(
						new IndustrialGrinderRecipe(oreStack, TechRebornAPI.recipeCompact.getItem("waterCell"), null,
								gemStack, dustStack, null, ItemCells.getCellByName("empty"), 100, 120));
			} catch (Exception e) {
				Core.logHelper.info("Failed to Load Grinder Recipe for Malachite Ore");
			}
		}

		// Implosion Compressor

		RecipeHandler.addRecipe(new ImplosionCompressorRecipe(ItemParts.getPartByName("iridiumAlloyIngot"),
				new ItemStack(TechRebornAPI.recipeCompact.getItem("industrialTnt").getItem(), 8),
				TechRebornAPI.recipeCompact.getItem("iridiumPlate"), ItemDusts.getDustByName("darkAshes", 4), 20, 30));
		RecipeHandler.addRecipe(new ImplosionCompressorRecipe(ItemDusts.getDustByName("diamond", 4),
				new ItemStack(TechRebornAPI.recipeCompact.getItem("industrialTnt").getItem(), 32),
				new ItemStack(TechRebornAPI.recipeCompact.getItem("industrialDiamond").getItem(), 3),
				ItemDusts.getDustByName("darkAshes", 16), 20, 30));
		RecipeHandler.addRecipe(new ImplosionCompressorRecipe(TechRebornAPI.recipeCompact.getItem("coalChunk"),
				new ItemStack(TechRebornAPI.recipeCompact.getItem("industrialTnt").getItem(), 8),
				TechRebornAPI.recipeCompact.getItem("industrialDiamond"), ItemDusts.getDustByName("darkAshes", 4), 20,
				30));
		RecipeHandler.addRecipe(new ImplosionCompressorRecipe(ItemDusts.getDustByName("emerald", 4),
				new ItemStack(TechRebornAPI.recipeCompact.getItem("industrialTnt").getItem(), 24),
				new ItemStack(Items.emerald, 3), ItemDusts.getDustByName("darkAshes", 12), 20, 30));
		RecipeHandler.addRecipe(new ImplosionCompressorRecipe(ItemDusts.getDustByName("sapphire", 4),
				new ItemStack(TechRebornAPI.recipeCompact.getItem("industrialTnt").getItem(), 24),
				ItemGems.getGemByName("sapphire", 3), ItemDusts.getDustByName("darkAshes", 12), 20, 30));
		RecipeHandler.addRecipe(new ImplosionCompressorRecipe(ItemDusts.getDustByName("ruby", 4),
				new ItemStack(TechRebornAPI.recipeCompact.getItem("industrialTnt").getItem(), 24),
				ItemGems.getGemByName("ruby", 3), ItemDusts.getDustByName("darkAshes", 12), 20, 30));
		RecipeHandler.addRecipe(new ImplosionCompressorRecipe(ItemDusts.getDustByName("yellowGarnet", 4),
				new ItemStack(TechRebornAPI.recipeCompact.getItem("industrialTnt").getItem(), 24),
				ItemGems.getGemByName("yellowGarnet", 3), ItemDusts.getDustByName("darkAshes", 12), 20, 30));
		RecipeHandler.addRecipe(new ImplosionCompressorRecipe(ItemDusts.getDustByName("redGarnet", 4),
				new ItemStack(TechRebornAPI.recipeCompact.getItem("industrialTnt").getItem(), 24),
				ItemGems.getGemByName("redGarnet", 3), ItemDusts.getDustByName("darkAshes", 12), 20, 30));
		RecipeHandler.addRecipe(new ImplosionCompressorRecipe(ItemDusts.getDustByName("peridot", 4),
				new ItemStack(TechRebornAPI.recipeCompact.getItem("industrialTnt").getItem(), 24),
				ItemGems.getGemByName("peridot", 3), ItemDusts.getDustByName("darkAshes", 12), 20, 30));

		// Grinder

		RecipeHandler.addRecipe(new IndustrialGrinderRecipe(new ItemStack(ModBlocks.ore, 1, 0),
				TechRebornAPI.recipeCompact.getItem("waterCell"), null, ItemDusts.getDustByName("galena", 2),
				ItemDustsSmall.getSmallDustByName("Sulfur", 1), ItemDustsSmall.getSmallDustByName("Silver", 1),
				ItemCells.getCellByName("empty"), 100, 120));
		RecipeHandler.addRecipe(
				new IndustrialGrinderRecipe(new ItemStack(ModBlocks.ore, 1, 0), ItemCells.getCellByName("mercury", 1),
						null, ItemDusts.getDustByName("galena", 2), ItemDustsSmall.getSmallDustByName("Sulfur", 1),
						ItemDusts.getDustByName("silver", 1), ItemCells.getCellByName("empty"), 100, 120));

		// Iridium Ore
		RecipeHandler.addRecipe(new IndustrialGrinderRecipe(new ItemStack(ModBlocks.ore, 1, 1), null,
				new FluidStack(FluidRegistry.WATER, 1000), TechRebornAPI.recipeCompact.getItem("iridiumOre"),
				ItemDustsSmall.getSmallDustByName("Iridium", 6), ItemDustsSmall.getSmallDustByName("Platinum", 2), null,
				100, 120));
		RecipeHandler.addRecipe(new IndustrialGrinderRecipe(new ItemStack(ModBlocks.ore, 1, 1),
				TechRebornAPI.recipeCompact.getItem("waterCell"), null,
				TechRebornAPI.recipeCompact.getItem("iridiumOre"), ItemDustsSmall.getSmallDustByName("Iridium", 6),
				ItemDustsSmall.getSmallDustByName("Platinum", 2), ItemCells.getCellByName("empty"), 100, 120));
		RecipeHandler.addRecipe(new IndustrialGrinderRecipe(new ItemStack(ModBlocks.ore, 1, 1),
				new ItemStack(Items.water_bucket), null, TechRebornAPI.recipeCompact.getItem("iridiumOre"),
				ItemDustsSmall.getSmallDustByName("Iridium", 6), ItemDustsSmall.getSmallDustByName("Platinum", 2),
				new ItemStack(Items.bucket), 100, 120));

		RecipeHandler.addRecipe(new IndustrialGrinderRecipe(new ItemStack(ModBlocks.ore, 1, 1), null,
				new FluidStack(ModFluids.fluidMercury, 1000), TechRebornAPI.recipeCompact.getItem("iridiumOre"),
				ItemDustsSmall.getSmallDustByName("Iridium", 6), ItemDusts.getDustByName("platinum", 2), null, 100,
				120));
		RecipeHandler.addRecipe(new IndustrialGrinderRecipe(new ItemStack(ModBlocks.ore, 1, 1),
				ItemCells.getCellByName("mercury", 1), null, TechRebornAPI.recipeCompact.getItem("iridiumOre"),
				ItemDustsSmall.getSmallDustByName("Iridium", 6), ItemDusts.getDustByName("platinum", 2),
				ItemCells.getCellByName("empty"), 100, 120));
		RecipeHandler.addRecipe(new IndustrialGrinderRecipe(new ItemStack(ModBlocks.ore, 1, 1),
				new ItemStack(ModItems.bucketMercury), null, TechRebornAPI.recipeCompact.getItem("iridiumOre"),
				ItemDustsSmall.getSmallDustByName("Iridium", 6), ItemDusts.getDustByName("platinum", 2),
				new ItemStack(Items.bucket), 100, 120));

		RecipeHandler.addRecipe(new IndustrialGrinderRecipe(new ItemStack(ModBlocks.ore, 1, 2),
				TechRebornAPI.recipeCompact.getItem("waterCell"), null, ItemGems.getGemByName("ruby", 1),
				ItemDustsSmall.getSmallDustByName("Ruby", 6), ItemDustsSmall.getSmallDustByName("Chrome", 2),
				ItemCells.getCellByName("empty"), 100, 120));

		RecipeHandler.addRecipe(new IndustrialGrinderRecipe(new ItemStack(ModBlocks.ore, 1, 3),
				TechRebornAPI.recipeCompact.getItem("waterCell"), null, ItemGems.getGemByName("sapphire", 1),
				ItemDustsSmall.getSmallDustByName("Sapphire", 6), ItemDustsSmall.getSmallDustByName("Aluminum", 2),
				ItemCells.getCellByName("empty"), 100, 120));

		RecipeHandler.addRecipe(new IndustrialGrinderRecipe(new ItemStack(ModBlocks.ore, 1, 4),
				TechRebornAPI.recipeCompact.getItem("waterCell"), null, ItemDusts.getDustByName("bauxite", 2),
				ItemDustsSmall.getSmallDustByName("Grossular", 4), ItemDustsSmall.getSmallDustByName("Titanium", 4),
				ItemCells.getCellByName("empty"), 100, 120));

		RecipeHandler.addRecipe(new IndustrialGrinderRecipe(new ItemStack(ModBlocks.ore, 1, 5),
				TechRebornAPI.recipeCompact.getItem("waterCell"), null, ItemDusts.getDustByName("pyrite", 2),
				ItemDustsSmall.getSmallDustByName("Sulfur", 1), ItemDustsSmall.getSmallDustByName("Phosphorous", 1),
				ItemCells.getCellByName("empty"), 100, 120));

		RecipeHandler.addRecipe(new IndustrialGrinderRecipe(new ItemStack(ModBlocks.ore, 1, 6),
				TechRebornAPI.recipeCompact.getItem("waterCell"), null, ItemDusts.getDustByName("cinnabar", 2),
				ItemDustsSmall.getSmallDustByName("Redstone", 1), ItemDustsSmall.getSmallDustByName("Glowstone", 1),
				ItemCells.getCellByName("empty"), 100, 120));

		RecipeHandler.addRecipe(new IndustrialGrinderRecipe(new ItemStack(ModBlocks.ore, 1, 7),
				TechRebornAPI.recipeCompact.getItem("waterCell"), null, ItemDusts.getDustByName("sphalerite", 2),
				ItemDustsSmall.getSmallDustByName("Zinc", 1), ItemDustsSmall.getSmallDustByName("YellowGarnet", 1),
				ItemCells.getCellByName("empty"), 100, 120));
		RecipeHandler.addRecipe(new IndustrialGrinderRecipe(new ItemStack(ModBlocks.ore, 1, 7),
				ItemCells.getCellByName("sodiumPersulfate", 1), null, ItemDusts.getDustByName("sphalerite", 2),
				ItemDusts.getDustByName("zinc", 1), ItemDustsSmall.getSmallDustByName("YellowGarnet", 1),
				ItemCells.getCellByName("empty"), 100, 120));

		RecipeHandler.addRecipe(new IndustrialGrinderRecipe(new ItemStack(ModBlocks.ore, 1, 8),
				TechRebornAPI.recipeCompact.getItem("waterCell"), null, ItemDusts.getDustByName("tungsten", 2),
				ItemDustsSmall.getSmallDustByName("Manganese", 1), ItemDustsSmall.getSmallDustByName("Silver", 1),
				ItemCells.getCellByName("empty"), 100, 120));
		RecipeHandler.addRecipe(
				new IndustrialGrinderRecipe(new ItemStack(ModBlocks.ore, 1, 8), ItemCells.getCellByName("mercury", 1),
						null, ItemDusts.getDustByName("tungsten", 2), ItemDustsSmall.getSmallDustByName("Manganese", 1),
						ItemDusts.getDustByName("silver", 2), ItemCells.getCellByName("empty"), 100, 120));

		RecipeHandler.addRecipe(new IndustrialGrinderRecipe(new ItemStack(ModBlocks.ore, 1, 9),
				TechRebornAPI.recipeCompact.getItem("waterCell"), null, ItemDusts.getDustByName("platinum", 2),
				ItemDustsSmall.getSmallDustByName("Iridium", 1), ItemDustsSmall.getSmallDustByName("Iridium", 1),
				ItemCells.getCellByName("empty"), 100, 120));
		RecipeHandler.addRecipe(
				new IndustrialGrinderRecipe(new ItemStack(ModBlocks.ore, 1, 9), ItemCells.getCellByName("mercury", 1),
						null, ItemDusts.getDustByName("platinum", 3), ItemDustsSmall.getSmallDustByName("Iridium", 1),
						ItemDustsSmall.getSmallDustByName("Iridium", 1), ItemCells.getCellByName("empty"), 100, 120));

		RecipeHandler.addRecipe(new IndustrialGrinderRecipe(new ItemStack(ModBlocks.ore, 1, 10),
				TechRebornAPI.recipeCompact.getItem("waterCell"), null, ItemGems.getGemByName("peridot", 1),
				ItemDustsSmall.getSmallDustByName("Peridot", 6), ItemDustsSmall.getSmallDustByName("Pyrope", 2),
				ItemCells.getCellByName("empty"), 100, 120));

		RecipeHandler.addRecipe(new IndustrialGrinderRecipe(new ItemStack(ModBlocks.ore, 1, 11),
				TechRebornAPI.recipeCompact.getItem("waterCell"), null, ItemDusts.getDustByName("sodalite", 12),
				ItemDustsSmall.getSmallDustByName("Lazurite", 4), ItemDustsSmall.getSmallDustByName("Lapis", 4),
				ItemCells.getCellByName("empty"), 100, 120));

		RecipeHandler.addRecipe(new IndustrialGrinderRecipe(new ItemStack(ModBlocks.ore, 1, 12),
				TechRebornAPI.recipeCompact.getItem("waterCell"), null, ItemDusts.getDustByName("tetrahedrite", 2),
				ItemDustsSmall.getSmallDustByName("Antimony", 1), ItemDustsSmall.getSmallDustByName("Zinc", 1),
				ItemCells.getCellByName("empty"), 100, 120));
		RecipeHandler.addRecipe(new IndustrialGrinderRecipe(new ItemStack(ModBlocks.ore, 1, 12),
				ItemCells.getCellByName("sodiumPersulfate", 1), null, ItemDusts.getDustByName("tetrahedrite", 3),
				ItemDustsSmall.getSmallDustByName("Antimony", 1), ItemDustsSmall.getSmallDustByName("Zinc", 1),
				ItemCells.getCellByName("empty"), 100, 120));

		// Chemical Reactor
		RecipeHandler.addRecipe(new ChemicalReactorRecipe(ItemDusts.getDustByName("calcite", 1), null,
				new ItemStack(TechRebornAPI.recipeCompact.getItem("fertilizer").getItem(), 1), 100, 30));
		RecipeHandler.addRecipe(new ChemicalReactorRecipe(ItemDusts.getDustByName("calcite", 1),
				ItemDusts.getDustByName("phosphorous", 1),
				new ItemStack(TechRebornAPI.recipeCompact.getItem("fertilizer").getItem(), 3), 100, 30));
		RecipeHandler.addRecipe(new ChemicalReactorRecipe(ItemCells.getCellByName("sodiumSulfide", 1),
				TechRebornAPI.recipeCompact.getItem("airCell"), ItemCells.getCellByName("sodiumPersulfate", 2), 2000,
				30));
		RecipeHandler.addRecipe(new ChemicalReactorRecipe(ItemCells.getCellByName("nitrocarbon", 1),
				TechRebornAPI.recipeCompact.getItem("waterCell"), ItemCells.getCellByName("glyceryl", 2), 580, 30));
		RecipeHandler.addRecipe(
				new ChemicalReactorRecipe(ItemDusts.getDustByName("calcite", 1), ItemDusts.getDustByName("sulfur", 1),
						new ItemStack(TechRebornAPI.recipeCompact.getItem("fertilizer").getItem(), 2), 100, 30));
		ItemStack waterCells = TechRebornAPI.recipeCompact.getItem("waterCell").copy();
		waterCells.stackSize = 2;
		RecipeHandler.addRecipe(new ChemicalReactorRecipe(ItemCells.getCellByName("sulfur", 1), waterCells,
				ItemCells.getCellByName("sulfuricAcid", 3), 1140, 30));
		ItemStack waterCells2 = TechRebornAPI.recipeCompact.getItem("waterCell").copy();
		waterCells2.stackSize = 5;
		RecipeHandler.addRecipe(new ChemicalReactorRecipe(ItemCells.getCellByName("hydrogen", 4),
				TechRebornAPI.recipeCompact.getItem("airCell"), waterCells2, 10, 30));
		RecipeHandler.addRecipe(new ChemicalReactorRecipe(ItemCells.getCellByName("nitrogen", 1),
				TechRebornAPI.recipeCompact.getItem("airCell"), ItemCells.getCellByName("nitrogenDioxide", 2), 1240,
				30));

		// IndustrialElectrolyzer

		RecipeHandler.addRecipe(new IndustrialElectrolyzerRecipe(ItemCells.getCellByName("sulfuricAcid", 7), null,
				ItemCells.getCellByName("hydrogen", 2), ItemDusts.getDustByName("sulfur"),
				ItemCells.getCellByName("empty", 2), ItemCells.getCellByName("empty", 3), 400, 90));

		RecipeHandler.addRecipe(new IndustrialElectrolyzerRecipe(ItemDusts.getDustByName("ruby", 6),
				ItemCells.getCellByName("empty"), ItemDusts.getDustByName("aluminum", 2),
				ItemCells.getCellByName("empty", 1), ItemDusts.getDustByName("chrome", 1), null, 140, 90));

		RecipeHandler.addRecipe(new IndustrialElectrolyzerRecipe(ItemDusts.getDustByName("sapphire", 5),
				ItemCells.getCellByName("empty"), ItemDusts.getDustByName("aluminum", 2),
				ItemCells.getCellByName("empty", 5), null, null, 100, 60));

		RecipeHandler.addRecipe(new IndustrialElectrolyzerRecipe(ItemCells.getCellByName("nitrogenDioxide", 3), null,
				ItemCells.getCellByName("nitrogen", 1), ItemCells.getCellByName("empty", 5), null,
				ItemCells.getCellByName("empty"), 160, 60));

		RecipeHandler.addRecipe(new IndustrialElectrolyzerRecipe(ItemCells.getCellByName("sodiumSulfide", 2), null,
				ItemCells.getCellByName("sodium", 1), ItemDusts.getDustByName("sulfur", 1), null,
				ItemCells.getCellByName("empty"), 200, 60));

		RecipeHandler.addRecipe(new IndustrialElectrolyzerRecipe(ItemDusts.getDustByName("peridot", 5),
				ItemCells.getCellByName("empty"), ItemDusts.getDustByName("aluminum", 2),
				ItemCells.getCellByName("empty", 5), null, null, 100, 60));

		RecipeHandler.addRecipe(new IndustrialElectrolyzerRecipe(ItemDusts.getDustByName("emerald", 29),
				ItemCells.getCellByName("empty", 18), ItemCells.getCellByName("berylium", 3),
				ItemDusts.getDustByName("aluminum", 2), ItemCells.getCellByName("silicon", 6),
				ItemCells.getCellByName("empty", 9), 520, 120));

		RecipeHandler
				.addRecipe(
						new IndustrialElectrolyzerRecipe(
								new ItemStack(TechRebornAPI.recipeCompact.getItem("silicondioxideDust").getItem(), 3,
										0),
								ItemCells.getCellByName("empty", 2), ItemCells.getCellByName("silicon", 1),
								ItemCells.getCellByName("empty", 1), null, null, 60, 60));

		RecipeHandler.addRecipe(new IndustrialElectrolyzerRecipe(new ItemStack(Items.dye, 3, 15),
				ItemCells.getCellByName("empty", 1), null, ItemCells.getCellByName("calcium", 1), null, null, 20, 106));

		RecipeHandler.addRecipe(new IndustrialElectrolyzerRecipe(ItemCells.getCellByName("glyceryl", 20), null,
				ItemCells.getCellByName("carbon", 3), ItemCells.getCellByName("hydrogen", 5),
				ItemCells.getCellByName("nitrogen", 3), ItemCells.getCellByName("empty", 9), 800, 90));

		RecipeHandler.addRecipe(new IndustrialElectrolyzerRecipe(ItemDusts.getDustByName("peridot", 9),
				ItemCells.getCellByName("empty", 4), ItemDusts.getDustByName("magnesium", 2),
				ItemDusts.getDustByName("iron"), ItemCells.getCellByName("silicon", 2),
				ItemCells.getCellByName("empty", 2), 200, 120));

		RecipeHandler.addRecipe(new IndustrialElectrolyzerRecipe(ItemCells.getCellByName("calciumCarbonate", 5), null,
				ItemCells.getCellByName("carbon"), ItemCells.getCellByName("calcium"),
				ItemCells.getCellByName("empty", 1), ItemCells.getCellByName("empty", 2), 400, 90));

		RecipeHandler.addRecipe(new IndustrialElectrolyzerRecipe(ItemCells.getCellByName("sodiumPersulfate", 6), null,
				ItemCells.getCellByName("sodium"), ItemDusts.getDustByName("sulfur"),
				ItemCells.getCellByName("empty", 2), ItemCells.getCellByName("empty", 3), 420, 90));

		RecipeHandler.addRecipe(new IndustrialElectrolyzerRecipe(ItemDusts.getDustByName("pyrope", 20),
				ItemCells.getCellByName("empty", 9), ItemDusts.getDustByName("aluminum", 2),
				ItemDusts.getDustByName("magnesium", 3), ItemCells.getCellByName("silicon", 3),
				ItemCells.getCellByName("empty", 9), 400, 120));

		ItemStack sand = new ItemStack(Blocks.sand);
		sand.stackSize = 16;

		RecipeHandler.addRecipe(new IndustrialElectrolyzerRecipe(sand, ItemCells.getCellByName("empty", 2),
				ItemCells.getCellByName("silicon", 1), ItemCells.getCellByName("empty", 2), null, null, 1000, 25));

		RecipeHandler.addRecipe(new IndustrialElectrolyzerRecipe(ItemDusts.getDustByName("almandine", 20),
				ItemCells.getCellByName("empty", 9), ItemDusts.getDustByName("aluminum", 2),
				ItemDusts.getDustByName("iron", 3), ItemCells.getCellByName("silicon", 3),
				ItemCells.getCellByName("empty", 6), 480, 120));

		RecipeHandler.addRecipe(new IndustrialElectrolyzerRecipe(ItemDusts.getDustByName("spessartine", 20),
				ItemCells.getCellByName("empty", 9), ItemDusts.getDustByName("aluminum", 2),
				ItemDusts.getDustByName("manganese", 3), ItemCells.getCellByName("silicon", 3),
				ItemCells.getCellByName("empty", 6), 480, 120));

		RecipeHandler.addRecipe(new IndustrialElectrolyzerRecipe(ItemDusts.getDustByName("andradite", 20),
				ItemCells.getCellByName("empty", 12), ItemCells.getCellByName("calcium", 3),
				ItemDusts.getDustByName("iron", 2), ItemCells.getCellByName("silicon", 3),
				ItemCells.getCellByName("empty", 6), 480, 120));

		RecipeHandler.addRecipe(new IndustrialElectrolyzerRecipe(ItemDusts.getDustByName("grossular", 20),
				ItemCells.getCellByName("empty", 12), ItemCells.getCellByName("calcium", 3),
				ItemDusts.getDustByName("aluminum", 2), ItemCells.getCellByName("silicon", 3),
				ItemCells.getCellByName("empty", 6), 440, 120));

		RecipeHandler.addRecipe(new IndustrialElectrolyzerRecipe(ItemDusts.getDustByName("Uvarovite", 20),
				ItemCells.getCellByName("empty", 12), ItemCells.getCellByName("calcium", 3),
				ItemDusts.getDustByName("chrome", 2), ItemCells.getCellByName("silicon", 3),
				ItemCells.getCellByName("empty", 6), 480, 120));

		RecipeHandler.addRecipe(new IndustrialElectrolyzerRecipe(ItemCells.getCellByName("empty", 6), null,
				ItemCells.getCellByName("hydrogen", 4), ItemCells.getCellByName("empty", 5),
				ItemCells.getCellByName("empty", 1), null, 100, 30));

		RecipeHandler.addRecipe(new IndustrialElectrolyzerRecipe(ItemDusts.getDustByName("darkAshes"),
				ItemCells.getCellByName("empty", 2), ItemCells.getCellByName("carbon", 2), null, null, null, 20, 30));

		if (OreUtil.doesOreExistAndValid("dustSalt")) {
			ItemStack salt = OreDictionary.getOres("dustSalt").get(0);
			salt.stackSize = 2;
			RecipeHandler.addRecipe(new IndustrialElectrolyzerRecipe(salt, ItemCells.getCellByName("empty", 2),
					ItemCells.getCellByName("sodium"), ItemCells.getCellByName("chlorine"), null, null, 40, 60));
		}

		Item drill = TechRebornAPI.recipeCompact.getItem("miningDrill").getItem();
		ItemStack drillStack = new ItemStack(drill, 1, OreDictionary.WILDCARD_VALUE);

		if (ConfigTechReborn.ExpensiveMacerator)
			CraftingHelper.addShapedOreRecipe(TechRebornAPI.recipeCompact.getItem("macerator"), "FDF", "DMD", "FCF",
					'F', Items.flint, 'D', Items.diamond, 'M', TechRebornAPI.recipeCompact.getItem("machine"), 'C',
					TechRebornAPI.recipeCompact.getItem("electronicCircuit"));

		if (ConfigTechReborn.ExpensiveDrill)
			CraftingHelper.addShapedOreRecipe(TechRebornAPI.recipeCompact.getItem("miningDrill"), " S ", "SCS", "SBS",
					'S', "ingotSteel", 'B', TechRebornAPI.recipeCompact.getItem("reBattery"), 'C',
					TechRebornAPI.recipeCompact.getItem("electronicCircuit"));

		if (ConfigTechReborn.ExpensiveDiamondDrill)
			CraftingHelper.addShapedOreRecipe(TechRebornAPI.recipeCompact.getItem("diamondDrill"), " D ", "DBD", "TCT",
					'D', "gemDiamond", 'T', "ingotTitanium", 'B', drillStack, 'C',
					TechRebornAPI.recipeCompact.getItem("advancedCircuit"));

		if (ConfigTechReborn.ExpensiveSolar)
			CraftingHelper.addShapedOreRecipe(TechRebornAPI.recipeCompact.getItem("solarPanel"), "PPP", "SZS", "CGC",
					'P', "paneGlass", 'S', ItemPlates.getPlateByName("silicon"), 'Z',
					TechRebornAPI.recipeCompact.getItem("carbonPlate"), 'G',
					TechRebornAPI.recipeCompact.getItem("generator"), 'C',
					TechRebornAPI.recipeCompact.getItem("electronicCircuit"));

		CraftingHelper.addShapedOreRecipe(ItemParts.getPartByName("iridiumAlloyIngot"), "IAI", "ADA", "IAI", 'I',
				ItemIngots.getIngotByName("iridium"), 'D', ItemDusts.getDustByName("diamond"), 'A',
				TechRebornAPI.recipeCompact.getItem("advancedAlloy"));

		CraftingHelper.addShapedOreRecipe(new ItemStack(ModItems.lithiumBatpack, 1, OreDictionary.WILDCARD_VALUE),
				"BCB", "BPB", "B B", 'B', new ItemStack(ModItems.lithiumBattery), 'P', "plateAluminum", 'C',
				TechRebornAPI.recipeCompact.getItem("advancedCircuit"));

		CraftingHelper.addShapedOreRecipe(new ItemStack(ModItems.lithiumBattery, 1, OreDictionary.WILDCARD_VALUE),
				" C ", "PFP", "PFP", 'F', ItemCells.getCellByName("lithium"), 'P', "plateAluminum", 'C',
				TechRebornAPI.recipeCompact.getItem("insulatedGoldCableItem"));

		CraftingHelper.addShapedOreRecipe(new ItemStack(ModItems.lapotronpack, 1, OreDictionary.WILDCARD_VALUE), "FOF",
				"SPS", "FIF", 'F', ItemParts.getPartByName("energyFlowCircuit"), 'O',
				new ItemStack(ModItems.lapotronicOrb), 'S', ItemParts.getPartByName("superConductor"), 'I',
				"ingotIridium", 'P', new ItemStack(ModItems.lapotronpack));
	}

	static void addGemToolRecipes(ItemStack gemsword, ItemStack gempick, ItemStack gemaxe, ItemStack gemHoe,
			ItemStack gemspade, ItemStack gemhelmet, ItemStack gemchestplate, ItemStack gemleggings, ItemStack gemboots,
			ItemStack gem) {
		CraftingHelper.addShapedOreRecipe(gemsword, " G ", " G ", " S ", 'S', Items.stick, 'G', gem);

		CraftingHelper.addShapedOreRecipe(gempick, "GGG", " S ", " S ", 'S', Items.stick, 'G', gem);

		CraftingHelper.addShapedOreRecipe(gemaxe, " GG", " SG", " S ", 'S', Items.stick, 'G', gem);

		CraftingHelper.addShapedOreRecipe(gemHoe, " GG", " S ", " S ", 'S', Items.stick, 'G', gem);

		CraftingHelper.addShapedOreRecipe(gemspade, " G ", " S ", " S ", 'S', Items.stick, 'G', gem);

		CraftingHelper.addShapedOreRecipe(gemhelmet, "GGG", "G G", "   ", 'G', gem);

		CraftingHelper.addShapedOreRecipe(gemchestplate, "G G", "GGG", "GGG", 'G', gem);

		CraftingHelper.addShapedOreRecipe(gemleggings, "GGG", "G G", "G G", 'G', gem);

		CraftingHelper.addShapedOreRecipe(gemboots, "   ", "G G", "G G", 'G', gem);
	}
}

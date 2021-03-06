/*
 * This file is part of TechReborn, licensed under the MIT License (MIT).
 *
 * Copyright (c) 2017 TechReborn
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package techreborn.utils;

import net.minecraft.block.Block;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagString;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import techreborn.init.ModBlocks;

import java.util.ArrayList;

/**
 * Created by Mark on 23/03/2016.
 */
public class StackWIPHandler {
	ArrayList<Block> wipBlocks = new ArrayList<>();
	public static ArrayList<ItemStack> devHeads = new ArrayList<>();

	public StackWIPHandler() {
		wipBlocks.add(ModBlocks.MAGICAL_ABSORBER);
		wipBlocks.add(ModBlocks.CHUNK_LOADER);
		wipBlocks.add(ModBlocks.MAGIC_ENERGY_CONVERTER);

		addHead("modmuss50");
		addHead("Gigabit101");
		addHead("ProfProspector");
		addHead("Rushmead");
	}

	private void addHead(String name) {
		ItemStack head = new ItemStack(Items.SKULL, 1, 3);
		head.setTagCompound(new NBTTagCompound());
		head.getTagCompound().setTag("SkullOwner", new NBTTagString(name));
		devHeads.add(head);
	}

	@SideOnly(Side.CLIENT)
	@SubscribeEvent
	public void toolTip(ItemTooltipEvent event) {
		Block block = Block.getBlockFromItem(event.getItemStack().getItem());
		if (block != null && wipBlocks.contains(block)) {
			event.getToolTip().add(TextFormatting.RED + "WIP Coming Soon");
		}

		if (devHeads.contains(event.getItemStack())) {
			event.getToolTip().add(TextFormatting.GOLD + "TechReborn Developer");
		}
	}
}

/*
 *  The MIT License (MIT)
 *
 *  Copyright (c) 2017:
 *      Ethan Brooks (CalmBit),
 *      and contributors
 *
 *  Permission is hereby granted, free of charge, to any person obtaining a copy of
 *  this software and associated documentation files (the "Software"), to deal in
 *  the Software without restriction, including without limitation the rights to
 *  use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies
 *  of the Software, and to permit persons to whom the Software is furnished to do
 *  so, subject to the following conditions:
 *
 *  The above copyright notice and this permission notice shall be included in all
 *  copies or substantial portions of the Software.
 *
 *  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 *  IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 *  FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 *  AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 *  LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 *  OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 *  SOFTWARE.
 *
 */

package com.elytradev.ville.registry;


import com.elytradev.concrete.inventory.gui.ConcreteContainer;
import com.elytradev.ville.Ville;
import com.elytradev.ville.entity.IExtendedMerchant;
import com.elytradev.ville.gui.GuiExtendedMerchant;
import com.elytradev.ville.inventory.ContainerExtendedMerchant;
import com.elytradev.ville.inventory.InventoryExtendedMerchant;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;

public class GuiRegistry implements IGuiHandler {

    public static final int GUI_EXTENDED_MERCHANT = 0;

    @Nullable
    @Override
    public Container getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        ConcreteContainer container = null;
        switch(ID) {
            case GUI_EXTENDED_MERCHANT: {
                Entity entity = world.getEntityByID(x);
                if(entity instanceof  IExtendedMerchant) {
                    IExtendedMerchant merchant = (IExtendedMerchant)entity;
                    container = new ContainerExtendedMerchant(player.inventory, merchant, new InventoryExtendedMerchant(player.inventory, merchant), world);
                }
                else {
                    Ville.LOG.error("Entity " + entity + " is not instanceof IExtendedMerchant - can't open ContainerExtendedMerchant!");
                }
            }
        }

        if(container != null)
            container.validate();

        return container;
    }

    @Nullable
    @Override
    @SideOnly(Side.CLIENT)
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        switch(ID) {
            case GUI_EXTENDED_MERCHANT: {
                Entity entity = world.getEntityByID(x);
                if(entity instanceof  IExtendedMerchant) {
                    return new GuiExtendedMerchant(player.inventory, (IExtendedMerchant)entity, world);
                }
                else {
                    Ville.LOG.error("Entity " + entity + " is not instanceof IExtendedMerchant - can't open GuiExtendedMerchant!");
                }
            }
        }
        return null;
    }

}

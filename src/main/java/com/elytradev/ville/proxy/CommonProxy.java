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

package com.elytradev.ville.proxy;

import com.elytradev.ville.Ville;
import com.elytradev.ville.entity.PigmanProfession;
import com.elytradev.ville.registry.GuiRegistry;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.registries.RegistryBuilder;

public class CommonProxy {

    public void init() {
        NetworkRegistry.INSTANCE.registerGuiHandler(Ville.INSTANCE, new GuiRegistry());

        PigmanProfession.PIGMAN_PROFESSION_REGISTRY =
                new RegistryBuilder<PigmanProfession>()
                        .setName(new ResourceLocation(Ville.MOD_ID, "pigmanProfessions"))
                        .setType(PigmanProfession.class)
                        .setIDRange(0,65535)
                        .create();
    }

    public void registerItemRenderer(Item item, int meta, String id) {
    }

}

/*
 * Copyright (C) 2024 MisterCheezeCake
 *
 * This file is part of YellowText.
 *
 * YellowText is free software: you can redistribute it
 * and/or modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation, either
 * version 3 of the License, or (at your option) any later version.
 *
 * YellowText is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with YellowText. If not, see <https://www.gnu.org/licenses/>.
 */
package wtf.cheeze.yellowtext.mixin;

import net.minecraft.client.gui.widget.PressableWidget;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.MathHelper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.awt.*;

@Mixin(PressableWidget.class)
public abstract class PressableWidgetMixin extends ClickableWidgetMixin {

	@ModifyArg(method = "renderWidget", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/widget/PressableWidget;drawMessage(Lnet/minecraft/client/gui/DrawContext;Lnet/minecraft/client/font/TextRenderer;I)V"), index = 2)
	private int adjustColor(int color) {
		int i = this.active ?  this.hovered ? 0xFFFFA0 : 16777215 : 10526880;
		return i | MathHelper.ceil(this.alpha * 255.0F) << 24;
	}

}

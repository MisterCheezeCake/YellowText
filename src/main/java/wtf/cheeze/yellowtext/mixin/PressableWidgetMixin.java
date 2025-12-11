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
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.text.Texts;
import net.minecraft.util.math.MathHelper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(PressableWidget.class)
public abstract class PressableWidgetMixin extends ClickableWidgetMixin {

	@ModifyArg(method = "drawLabel", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/widget/PressableWidget;drawTextWithMargin(Lnet/minecraft/client/font/DrawnTextConsumer;Lnet/minecraft/text/Text;I)V"), index = 1)
	private Text modifyTextColor(Text text) {
		int baseColor = this.active ? (this.hovered ? 0xFFFFA0 : 0xFFFFFF) : 0xA0A0A0;
		int colorWithAlpha = baseColor | (MathHelper.ceil(this.alpha * 255.0F) << 24);

		return Texts.withStyle(text, Style.EMPTY.withColor(colorWithAlpha));
	}

}
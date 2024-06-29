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

import net.minecraft.client.gui.widget.ClickableWidget;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(ClickableWidget.class)
public abstract class ClickableWidgetMixin {

	@Shadow
	public boolean active;

	@Shadow
	protected float alpha;

	@Shadow
	protected boolean hovered;

}

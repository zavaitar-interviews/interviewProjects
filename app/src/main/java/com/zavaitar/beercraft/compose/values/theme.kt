package com.zavaitar.beercraft.compose.values

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.MaterialTheme.shapes
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val LightColorPalette = lightColors(
    primary = primary,
    secondary = textColorLight,
    surface = lightGrey,
    primaryVariant = gridLineColorLight,
    onPrimary = accent,
    onSurface = accent
)

private val DarkColorPalette = darkColors(
    // main background color
    primary = primaryDark,
    // used for text color
    secondary = textColorDark,
    surface = lightGreyAlpha,
    primaryVariant = gridLineColorLight,
    onPrimary = accent,
    onSurface = accent
)

@Composable
fun AppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    // TODO HEL-1847 add darkTheme colors or not use it at all
    MaterialTheme(
        colors = if (darkTheme) DarkColorPalette else LightColorPalette,
        typography = typography,
        shapes = shapes,
        content = content
    )
}

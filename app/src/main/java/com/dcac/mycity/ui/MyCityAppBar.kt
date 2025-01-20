package com.dcac.mycity.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Surface
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.dcac.mycity.R
import com.dcac.mycity.model.Category
import com.dcac.mycity.model.City
import com.dcac.mycity.model.MyCityUiState
import com.dcac.mycity.ui.theme.MyCityTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyCityAppTopBar(
    myCityUiState: MyCityUiState,
    onCitySelectedClick: (City) -> Unit,
    modifier: Modifier = Modifier
) {
    var isMenuExpanded by remember { mutableStateOf(false) }

    TopAppBar(
        title = { },
        navigationIcon = {
            MyCityAppLogo(
                modifier = Modifier
                    .size(dimensionResource(R.dimen.topbar_logo_text_size))
                    .padding(start = dimensionResource(R.dimen.topbar_logo_padding))
            )
        },
        actions = {
            Box {
                CityMenuItem(
                    city = myCityUiState.currentCity,
                    modifier = Modifier
                        .size(dimensionResource(R.dimen.topbar_logo_city_image_size))
                        .clip(CircleShape)
                        .clickable(
                            onClick = { isMenuExpanded = true },
                            indication = null,
                            interactionSource = remember { MutableInteractionSource() }
                        )
                )

                DropdownMenu(
                    expanded = isMenuExpanded,
                    onDismissRequest = { isMenuExpanded = false },
                    modifier = Modifier.width(dimensionResource(R.dimen.topbar_logo_city_image_size))
                ) {
                    myCityUiState.availableCities.keys.forEach { city ->
                        DropdownMenuItem(
                            text = {},
                            leadingIcon = {
                                Image(
                                    painter = painterResource(id = city.imageIconId),
                                    contentDescription = city.name,
                                    modifier = Modifier
                                        .size(dimensionResource(R.dimen.topbar_logo_city_image_size))
                                        .clip(CircleShape)
                                )
                            },
                            onClick = {
                                onCitySelectedClick(city)
                                isMenuExpanded = false
                            },
                        )
                    }
                }
            }
        },
        modifier = modifier
    )
}

@Composable
private fun MyCityAppLogo(modifier: Modifier) {
    Image(
        painter = painterResource(id = R.drawable.logo_text),
        contentDescription = stringResource(R.string.logo_text),
        modifier = modifier
    )
}

@Composable
private fun CityMenuItem(city: City, modifier: Modifier) {
        Image(
            painter = painterResource(id = city.imageIconId),
            contentDescription = city.name,
            modifier = modifier
        )
}

@Composable
fun MyCityAppBottomNavigationBar(
    myCityUiState: MyCityUiState,
    onTabPressed: ((Category) -> Unit),
    modifier: Modifier
) {

    val currentCategory = myCityUiState.currentCategory

    val navigationItemContentList = listOf(
        NavigationItemContent(
            category = Category.museum,
            icon = R.drawable.icon_museum,
            text = stringResource(R.string.museum)
        ),
        NavigationItemContent(
            category = Category.maul,
            icon = R.drawable.icon_maul,
            text = stringResource(R.string.maul)
        ),
        NavigationItemContent(
            category = Category.restaurant,
            icon = R.drawable.icon_restaurant,
            text = stringResource(R.string.restaurant)
        ),
        NavigationItemContent(
            category = Category.bar,
            icon = R.drawable.icon_bar,
            text = stringResource(R.string.bar)
        ),
        NavigationItemContent(
            category = Category.nightclub,
            icon = R.drawable.icon_nightclub,
            text = stringResource(R.string.nightclub)
        )
    )

    NavigationBar(modifier = modifier) {
        for (navItem in navigationItemContentList) {
            NavigationBarItem(
                selected = currentCategory == navItem.category,
                onClick = { onTabPressed(navItem.category) },
                icon = {
                    Icon(
                        painter = painterResource(id = navItem.icon),
                        contentDescription = navItem.text
                    )
                }
            )
        }
    }
}

private data class NavigationItemContent(
    val category: Category,
    val icon: Int,
    val text: String
)

@Composable
@Preview
fun MyCityAppTopBarPreview() {
    val myCityUiState = MyCityUiState(isCityMenuExpanded = true)
    MyCityTheme {
        Surface {
            MyCityAppTopBar(
                modifier = Modifier,
                myCityUiState = myCityUiState,
                onCitySelectedClick = {}
            )
        }
    }
}
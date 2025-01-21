package com.dcac.mycity.ui

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.Surface
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.dcac.mycity.R
import com.dcac.mycity.model.Category
import com.dcac.mycity.model.City
import com.dcac.mycity.model.MyCityUiState
import com.dcac.mycity.ui.theme.MyCityTheme
import com.dcac.mycity.ui.utils.MyCityNavigationType

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyCityAppTopBar(
    myCityUiState: MyCityUiState,
    onLogoClick: () -> Unit,
    onCitySelectedClick: (City) -> Unit,
    onBackButtonClick: () -> Unit,
    onDevForwardClick: () -> Unit,
    isDevScreen: Boolean,
    modifier: Modifier = Modifier
) {
    var isMenuExpanded by remember { mutableStateOf(false) }

    TopAppBar(
        title = { },
        navigationIcon = {
            when {
                isDevScreen -> {
                    // Dev screen: MyCity logo
                    MyCityAppLogo(
                        onLogoClick = {},
                        modifier = Modifier
                            .size(dimensionResource(R.dimen.topbar_logo_text_size))
                            .padding(start = dimensionResource(R.dimen.topbar_logo_padding))
                    )
                }
                !myCityUiState.isShowingHomepage -> {
                    // Details page : return logo
                    IconButton(onClick = onBackButtonClick) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = stringResource(R.string.back_button)
                        )
                    }
                }
                else -> {
                    // Home : MyCity logo
                    MyCityAppLogo(
                        onLogoClick = onLogoClick,
                        modifier = Modifier
                            .size(dimensionResource(R.dimen.topbar_logo_text_size))
                            .padding(start = dimensionResource(R.dimen.topbar_logo_padding))
                    )
                }
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        ),
        actions = {
            when {
                isDevScreen -> {
                    // Flèche forward pour la page Dev
                    IconButton(onClick = onDevForwardClick) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                            contentDescription = stringResource(R.string.dev_screen_forward_button)
                        )
                    }
                }
                else -> {
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
                }
            }
        },
        modifier = modifier
    )
}

@Composable
private fun MyCityAppLogo(
    onLogoClick: () -> Unit,
    modifier: Modifier) {
    Image(
        painter = painterResource(id = R.drawable.logo_text),
        contentDescription = stringResource(R.string.logo_text),
        modifier = modifier.clickable(onClick = onLogoClick)
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
                },
            )
        }
    }
}
@Composable
fun MyCityAppNavigationRail(
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
    NavigationRail(modifier = modifier) {
        Column(
            modifier = Modifier.fillMaxHeight(),
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            for (navItem in navigationItemContentList){
                NavigationRailItem(
                    selected = currentCategory == navItem.category,
                    onClick = { onTabPressed(navItem.category) },
                    icon = {
                        Icon(
                            painter = painterResource(id = navItem.icon),
                            contentDescription = navItem.text)
                    }
                )
            }
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
                onCitySelectedClick = {},
                onLogoClick = {},
                onBackButtonClick = {},
                onDevForwardClick = {},
                isDevScreen = false
            )
        }
    }
}
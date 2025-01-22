package com.dcac.mycity.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.dcac.mycity.R
import com.dcac.mycity.datasource.LocalNavigationCategoriesContentDataProvider
import com.dcac.mycity.model.Category
import com.dcac.mycity.model.City
import com.dcac.mycity.model.MyCityUiState
import com.dcac.mycity.ui.theme.MyCityTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyCityAppTopBar(
    myCityUiState: MyCityUiState,
    onLogoAppClick: () -> Unit,
    onCitySelectedClick: (City) -> Unit,
    onBackArrowClick: () -> Unit,
    onDevForwardArrowClick: () -> Unit,
    isDevScreen: Boolean,
    modifier: Modifier
) {
    var isMenuExpanded by remember { mutableStateOf(false) }

    TopAppBar(
        title = { },
        navigationIcon = {
            when {
                isDevScreen -> {
                    // Dev screen: MyCity logo
                    MyCityAppLogo(
                        onLogoAppClick = {},
                        modifier = Modifier
                            .padding(start = dimensionResource(R.dimen.padding_small))
                    )
                }
                myCityUiState.isShowingDetailPage -> {
                    // Details page : return logo
                    IconButton(onClick = onBackArrowClick) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = stringResource(R.string.back_button)
                        )
                    }
                }
                else -> {
                    // Home : MyCity logo
                    MyCityAppLogo(
                        onLogoAppClick = onLogoAppClick,
                        modifier = Modifier
                            .padding(start = dimensionResource(R.dimen.padding_small))
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
                    IconButton(onClick = onDevForwardArrowClick) {
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
                                .padding(end = dimensionResource(R.dimen.padding_small))
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
                                            contentDescription = stringResource(id = city.name),
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
    onLogoAppClick: () -> Unit,
    modifier: Modifier) {
    Image(
        painter = painterResource(id = R.drawable.logo_text),
        contentDescription = stringResource(R.string.logo_text),
        modifier = modifier
            .clickable(onClick = onLogoAppClick)
            .size(dimensionResource(R.dimen.topbar_logo_text_size))
    )
}

@Composable
private fun CityMenuItem(city: City, modifier: Modifier) {
        Image(
            painter = painterResource(id = city.imageIconId),
            contentDescription = stringResource(id = city.name),
            modifier = modifier
        )
}

@Composable
fun MyCityAppBottomNavigationBar(
    myCityUiState: MyCityUiState,
    onCategoryTabPressed: ((Category) -> Unit),
    modifier: Modifier
) {

    NavigationBar(modifier = modifier) {
        for (navItem in myCityUiState.navigationCategoriesContent) {
            NavigationBarItem(
                selected = myCityUiState.currentCategory == navItem.category,
                onClick = { onCategoryTabPressed(navItem.category) },
                icon = {
                    Icon(
                        painter = painterResource(id = navItem.icon),
                        contentDescription = stringResource(id = navItem.text)
                    )
                },
            )
        }
    }
}
@Composable
fun MyCityAppNavigationRail(
    myCityUiState: MyCityUiState,
    onCategoryTabPressed: ((Category) -> Unit),
    modifier: Modifier
) {
    NavigationRail(modifier = modifier) {
        Column(
            modifier = Modifier.fillMaxHeight()
        ) {
            for (navItem in myCityUiState.navigationCategoriesContent){
                NavigationRailItem(
                    selected = myCityUiState.currentCategory == navItem.category,
                    onClick = { onCategoryTabPressed(navItem.category) },
                    icon = {
                        Icon(
                            painter = painterResource(id = navItem.icon),
                            contentDescription = stringResource(id = navItem.text)
                        )
                    }
                )
            }
        }
    }
}

@Composable
fun MyCityAppNavigationDrawer(
    myCityUiState: MyCityUiState,
    onCitySelectedClick: (City) -> Unit,
    onLogoAppClick: () -> Unit,
    onCategoryTabPressed: ((Category) -> Unit),
    modifier: Modifier
) {

    Column(modifier = modifier.fillMaxHeight()) {
        MyCityAppNavigationDrawerHeader(
            myCityUiState = myCityUiState,
            onCitySelectedClick = onCitySelectedClick,
            onLogoAppClick = onLogoAppClick,
        )
        for (navItem in myCityUiState.navigationCategoriesContent) {
            NavigationDrawerItem(
                selected = myCityUiState.currentCategory == navItem.category,
                label = {
                    Text(
                        text = stringResource(id = navItem.text),
                        modifier = Modifier.padding(horizontal = dimensionResource(R.dimen.padding_medium))
                    )
                },
                onClick = { onCategoryTabPressed(navItem.category) },
                icon = {
                    Icon(
                        painter = painterResource(id = navItem.icon),
                        contentDescription = stringResource(id = navItem.text)
                    )
                },
            )
        }
    }
}

@Composable
private fun MyCityAppNavigationDrawerHeader(
    myCityUiState: MyCityUiState,
    onCitySelectedClick: (City) -> Unit,
    onLogoAppClick: () -> Unit
) {

    var isMenuExpanded by remember { mutableStateOf(false) }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                start = dimensionResource(R.dimen.padding_medium),
                end = dimensionResource(R.dimen.padding_small)
            ),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        MyCityAppLogo(
            onLogoAppClick = onLogoAppClick,
            modifier = Modifier
        )
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
                            contentDescription = stringResource(id = city.name),
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

@Composable
@Preview
fun MyCityAppTopBarPreview() {
    MyCityTheme {
        val exampleUiState = MyCityUiState()
        Surface {
            MyCityAppTopBar(
                modifier = Modifier,
                myCityUiState = exampleUiState,
                onCitySelectedClick = {},
                onLogoAppClick = {},
                onBackArrowClick = {},
                onDevForwardArrowClick = {},
                isDevScreen = false
            )
        }
    }
}

@Composable
@Preview
fun MyCityAppBottomBarPreview() {
    MyCityTheme {
        val exampleNavigationCategoriesContent = LocalNavigationCategoriesContentDataProvider.navigationCategoriesContentLists
        val exampleUiState = MyCityUiState(
            navigationCategoriesContent = exampleNavigationCategoriesContent
        )
        Surface {
            MyCityAppBottomNavigationBar(
                modifier = Modifier,
                myCityUiState = exampleUiState,
                onCategoryTabPressed = {}
            )
        }
    }
}

@Composable
@Preview
fun MyCityAppNavigationRailPreview() {
    MyCityTheme {
        val exampleNavigationCategoriesContent = LocalNavigationCategoriesContentDataProvider.navigationCategoriesContentLists
        val exampleUiState = MyCityUiState(
            navigationCategoriesContent = exampleNavigationCategoriesContent
        )
        Surface {
            MyCityAppNavigationRail(
                modifier = Modifier,
                myCityUiState = exampleUiState,
                onCategoryTabPressed = {}
            )
        }
    }
}

@Composable
@Preview
fun MyCityAppNavigationDrawerPreview() {
    MyCityTheme {
        val exampleNavigationCategoriesContent = LocalNavigationCategoriesContentDataProvider.navigationCategoriesContentLists
        val exampleUiState = MyCityUiState(
            navigationCategoriesContent = exampleNavigationCategoriesContent
        )
        Surface {
            MyCityAppNavigationDrawer(
                modifier = Modifier,
                myCityUiState = exampleUiState,
                onCitySelectedClick = {},
                onLogoAppClick = {},
                onCategoryTabPressed = {}
            )
        }
    }
}
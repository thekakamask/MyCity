package com.dcac.mycity.ui.utils

import androidx.annotation.StringRes
import com.dcac.mycity.R

enum class MyCityAppScreenEnum(@StringRes val title: Int) {
    HomePage(title = R.string.home_page),
    DevPage(title = R.string.dev_page)
}
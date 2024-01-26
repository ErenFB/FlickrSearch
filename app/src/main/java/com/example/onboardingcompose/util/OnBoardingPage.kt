package com.example.onboardingcompose.util

import androidx.annotation.DrawableRes
import com.example.onboardingcompose.R

sealed class OnBoardingPage(

    object First : OnBoardingPage(
image = R.drawable.logo1,
title = "Image Search",
description = "Search and Find What You Want"
)

object Second : OnBoardingPage(
    image = R.drawable.second1,
    title = "WRITE",
    description = "First Write Your Words"
)

object Third : OnBoardingPage(
    image = R.drawable.first2,
    title = "SEARCH",
    description = "THEN CLICK SEARCH BUTTON"
)@DrawableRes
    val image: Int,
    val title: String,
    val description: String
) {
}

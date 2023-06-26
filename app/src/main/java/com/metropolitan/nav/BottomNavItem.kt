package com.metropolitan.nav

import com.metropolitan.R

sealed class BottomNavItem(var title:String, var icon:Int, var screen_route:String){

    object Home : BottomNavItem("Home", R.drawable.ic_home,"home")
    object Map: BottomNavItem("Map",R.drawable.ic_map,"map")
    object Scan: BottomNavItem("Scan",R.drawable.ic_scan,"scan")
    object Profile: BottomNavItem("Profile",R.drawable.ic_profile,"profile")
}
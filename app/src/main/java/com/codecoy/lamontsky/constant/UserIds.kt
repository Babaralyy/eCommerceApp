package com.codecoy.lamontsky.constant

import androidx.lifecycle.ViewModel
import com.codecoy.lamontsky.datamodels.SubCategoriesData

object UserIds : ViewModel() {
    var productCatId: Int = 0
    var subCatId: Int = 0

    var subCategoriesData = SubCategoriesData()


}
package com.ory.stark.esigntesttask.ui.home

import androidx.annotation.IdRes
import androidx.annotation.StringRes
import com.ory.stark.esigntesttask.R

/**
 * Created by Oryna Starkina on 12.01.2022.
 * Email: oryna.stark@gmail.com
 */
data class RecentAction(
    val documentTitle: String,
    val status: DocumentStatus
)

enum class DocumentStatus(@IdRes val icon: Int, @StringRes val title: Int){
    Waiting(R.drawable.ic_waiting, R.string.waiting),
    Signed(R.drawable.ic_signed, R.string.signed),
    Voided(R.drawable.ic_voided, R.string.voided)
}
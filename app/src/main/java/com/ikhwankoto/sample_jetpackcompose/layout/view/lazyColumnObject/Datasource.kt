package com.ikhwankoto.sample_jetpackcompose.layout.view.lazyColumnObject

import com.ikhwankoto.sample_jetpackcompose.R


class Datasource() {
    fun loadAffirmations(): List<Affirmation> {
        return listOf<Affirmation>(
            Affirmation(R.string.affirmation1, R.drawable.image1),
            Affirmation(R.string.affirmation1, R.drawable.image1),
            Affirmation(R.string.affirmation1, R.drawable.image1),
            Affirmation(R.string.affirmation1, R.drawable.image1),
            Affirmation(R.string.affirmation1, R.drawable.image1),
            Affirmation(R.string.affirmation1, R.drawable.image1),
            Affirmation(R.string.affirmation1, R.drawable.image1),
            Affirmation(R.string.affirmation1, R.drawable.image1),
            Affirmation(R.string.affirmation1, R.drawable.image1),
            Affirmation(R.string.affirmation1, R.drawable.image1)
        )
    }
}
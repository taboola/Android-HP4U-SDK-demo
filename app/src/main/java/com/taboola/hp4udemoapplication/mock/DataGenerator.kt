package com.taboola.hp4udemoapplication.mock

import com.taboola.hp4udemoapplication.data.Article
import com.taboola.hp4udemoapplication.data.BaseItem
import com.taboola.hp4udemoapplication.data.Header

class DataGenerator {

    companion object {
        private const val CATEGORY_1: String = "Top";
        private const val CATEGORY_2: String = "Sports";
        private const val CATEGORY_3: String = "Tech";
        fun getGeneratedData(): ArrayList<BaseItem> {

            val data = ArrayList<BaseItem>()

            data.add(
                Article(
                    "Boris Johnson news – live: PM to deliver speech on housing plan to boost ownership",
                    "Boris Johnson is set to make a speech on new housing plans which will allow people to use their benefits to get on the property ladder.",
                    "https://images.taboola.com/taboola/image/fetch/f_jpg%2Cq_auto%2Cq_100%2Ch_916%2Cw_856%2Cc_fill%2Cg_faces:auto/https://static.independent.co.uk/2022/06/08/09/Britain_Politics_Conservative_Contenders_42700.jpg",
                    "https://taboolanews.com/summary-page/3958769272852809802",
                    CATEGORY_1
                )
            )
            data.add(Header(CATEGORY_1))
            for (i in 0..10) {
                data.add(
                    Article(
                        "Awkward arrest sees naked man and woman in towel arrested in Florida, deputies say",
                        "Awkward arrest sees naked man and woman in towel arrested in Florida, deputies say " +
                                "A naked man and a women in a towel were arrested in Polk County, Florida, when sheriff’s deputies picked a particularly awkward moment to make a felony arrest. " +
                                "The 29-year-old suspect, a man, was in his shower — with a",
                        "https://images.taboola.com/taboola/image/fetch/f_jpg%2Cq_auto%2Cq_100%2Ch_916%2Cw_856%2Cc_fill%2Cg_faces:auto/https://www.sunherald.com/news/local/crime/o08arx/picture260659737/alternates/LANDSCAPE_1140/Wake%20inmate%20assault",
                        "https://taboolanews.com/summary-page/3958769272852809802",
                        CATEGORY_1
                    )
                )
            }


            data.add(Header(CATEGORY_2))
            for (i in 0..10) {
                data.add(
                    Article(
                        "The unreal Warriors wrinkle in Game 4 that could spell trouble for Celtics",
                        "The Golden State Warriors bodied the Boston Celtics in Game 4, with Stephen Curry throwing haymaker after haymaker to tie the series at 2-2." +
                                "Stephen Curry poured in a scorching-hot 43 points to lead his Warriors to victory. But based on the numbers, it could have gone a lot worse for the Celtics side",
                        "https://images.taboola.com/taboola/image/fetch/f_jpg%2Cq_auto%2Cq_100%2Ch_916%2Cw_856%2Cc_fill%2Cg_faces:auto/https://clutchpoints.com/wp-content/uploads/2022/06/curry-1000x600.jpeg",
                        "https://taboolanews.com/summary-page/301750375827540446",
                        CATEGORY_2
                    )
                )
            }


            data.add(Header(CATEGORY_3))
            for (i in 0..10) {
                data.add(
                    Article(
                        "Telegram Is Going to Introduce Premium Subscriptions",
                        "Telegram CEO Pavel Durov has announced the messaging app, which has been free to use since it debuted in 2013, is going to introduce a subscription-based Premium offering. " +
                                "\"After giving it some thought,\" Durov says, \"we realized that the only way to let our most demanding fans get more while keeping",
                        "https://images.taboola.com/taboola/image/fetch/f_jpg%2Cq_auto%2Cq_100%2Ch_916%2Cw_856%2Cc_fill%2Cg_faces:auto/https%3A%2F%2Fi.pcmag.com%2Fimagery%2Farticles%2F01WcFU75wpbaMQMI7me3R2l-1..v1654973957.jpg",
                        "https://taboolanews.com/article/c92b9de7-6eab-780c-0d6e-cadf628ffee6",
                        CATEGORY_3
                    )
                )
            }
            return data
        }
    }
}
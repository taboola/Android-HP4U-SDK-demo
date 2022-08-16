package com.taboola.hp4udemoapplication.repository

import com.taboola.hp4udemoapplication.HP4UDemoConstants
import com.taboola.hp4udemoapplication.R
import com.taboola.hp4udemoapplication.model.Article
import com.taboola.hp4udemoapplication.model.BaseItem
import com.taboola.hp4udemoapplication.model.Header

class MockDataGenerator {

    companion object {
        private const val CATEGORY_0: String = "Health";
        private const val CATEGORY_1: String = "Sports";
        private const val CATEGORY_2: String = "Tech";
        private const val CATEGORY_3: String = "News";


        fun getGeneratedData(): ArrayList<BaseItem> {

            val data = ArrayList<BaseItem>()

            data.add(
                Article(
                    "Get healthy, go green space",
                    "In the best, we've written a great deal about the health benefits",
                    R.drawable.image_p072bwvx,
                    "https://taboolanews.com/summary-page/3687694654531729572",
                    CATEGORY_0,
                    CATEGORY_0
                )
            )
            addSportsItems(data)
            addTechItems(data)
            addNewsItems(data)
            return data
        }

        private fun addSportsItems(data: ArrayList<BaseItem>) {
            data.add(Header(CATEGORY_1))
            data.add(
                Article(
                    "F1 news LIVE: Latest news and updates from Formula 1",
                    "Formula 1 legends Sir Jackie Stewart and David Coulthard have urged Lewis Hamilton to ‘step aside’ and ‘retire’ from the sport to avoid the ‘pain’ of not being able to compete as he used to behind the wheel. Hamilton has struggled to adapt to Mercedes new W13 car in 2022 only finishing on the podium",
                    R.drawable.image_1403894617,
                    "https://taboolanews.com/summary-page/6540470742340777419",
                    CATEGORY_1,
                    HP4UDemoConstants.SECTION_1_NAME
                )
            )
            data.add(
                Article(
                    "F1 Azerbaijan Grand Prix live stream: How can I watch today’s race live on TV in the UK?",
                    "Formula One heads to Baku this weekend for the Azerbaijan Grand Prix. Sergio Perez is the man in form in the Red Bull after securing a frantic victory around Monaco a fortnight ago at the expense of Charles Leclerc. The Ferrari man lagged home in fourth after a series of errors from his team, although",
                    R.drawable.image_1402092779,
                    "https://taboolanews.com/article/da70e1ae-6b54-fc55-e793-26e11580d13c",
                    CATEGORY_1,
                    HP4UDemoConstants.SECTION_1_NAME
                )
            )
            data.add(
                Article(
                    "Brandon Williams 'is surplus to requirements at Manchester United' despite the arrival of new boss Erik ten Hag and 'could leave for around £10m' after impressing on loan at Norwich",
                    "Manchester United are 'willing to sell Brandon Williams' despite his impressive loan spell at Norwich last season.\n" +
                            "The 21-year-old will be allowed to leave for 'around £10m' as new United boss Erik ten Hag builds his new squad.\n" +
                            "Williams would have struggled for play time in a team that also includes ",
                    R.drawable.image_1655971200021,
                    "https://taboolanews.com/summary-page/1890589688136913531",
                    CATEGORY_1,
                    HP4UDemoConstants.SECTION_1_NAME
                )
            )
            data.add(
                Article(
                    "Is England vs New Zealand on TV? Start time, channel and how to watch third Test",
                    "England face New Zealand in the final Test of their three-match series having already sewn up victory with two wins from the opening two. The hosts entertain at Headingley having earned an insurmountable 2-0 lead at Lord’s and Trent Bridge. Ben Stokes has got off to the perfect start as captain",
                    R.drawable.image_0852c8f1790ee93,
                    "https://taboolanews.com/summary-page/2808604443521689519",
                    CATEGORY_1,
                    HP4UDemoConstants.SECTION_1_NAME
                )
            )
        }

        private fun addTechItems(data: ArrayList<BaseItem>) {
            data.add(Header(CATEGORY_2))
            data.add(
                Article(
                    "Telegram Is Going to Introduce Premium Subscriptions",
                    "Telegram CEO Pavel Durov has announced the messaging app, which has been free to use since it debuted in 2013, is going to introduce a subscription-based Premium offering. \"After giving it some thought,\" Durov says, \"we realized that the only way to let our most demanding fans get more while keeping",
                    R.drawable.image_1654973957,
                    "https://taboolanews.com/article/c92b9de7-6eab-780c-0d6e-cadf628ffee6",
                    CATEGORY_2,
                    HP4UDemoConstants.SECTION_2_NAME
                )
            )
            data.add(
                Article(
                    "The 10 best and funniest tweets of the week",
                    "You there! The elegant-looking person reading a blog on your device. You like tweets, do you not? Well, guess what? I've collected the absolute best and funniest tweets from this week. Why? Because I do it every week, my good pal. This week was especially great for funny tweets.",
                    R.drawable.image_123456789,
                    "https://taboolanews.com/article/1ef8b294-8524-ffe6-df2c-5a6da70f85ba",
                    CATEGORY_2,
                    HP4UDemoConstants.SECTION_2_NAME
                )
            )
            data.add(
                Article(
                    "Tim Cook asks for federal privacy law in a letter to Congress, knowing Apple can handle it",
                    "It’s possible to be selfless and a little selfish at the same time. That’s the needle Apple CEO Tim Cook is seemingly trying to thread, anyway. In a letter to congress that you can read in full courtesy of 9to5Mac, Cook advocated for the passage of a federal data privacy law that would offer privacy",
                    R.drawable.image_987654321,
                    "https://taboolanews.com/article/388e4504-05cd-8603-6c67-07e9f66a5cfa",
                    CATEGORY_2,
                    HP4UDemoConstants.SECTION_2_NAME
                )
            )
            data.add(
                Article(
                    "10 games worth checking out from GC3's games showcase",
                    "Summer Games Fest 2022 keeps chugging along with Guerrilla Collective's showcase of indie games returning once again. Simply called \"GC3,\" the third annual event showcase announced and revealed more than 40 games during its 90-minute runtime. From games that'll raise your heartbeat to games that'll",
                    R.drawable.image_222222222,
                    "https://taboolanews.com/article/034b2e1b-0c60-fd8a-d756-74041c8b7280",
                    CATEGORY_2,
                    HP4UDemoConstants.SECTION_2_NAME
                )
            )
        }

        private fun addNewsItems(data: ArrayList<BaseItem>) {
            data.add(Header(CATEGORY_3))
            data.add(
                Article(
                    "Profits at ExxonMobil, Chevron skyrocket with oil prices",
                    "US oil giants ExxonMobil and Chevron -- targets of White House criticism over soaring gasoline costs -- reported record quarterly profits Friday amid the war in Ukraine that sparked a steep rise in energy prices.",
                    R.drawable.image_333333333,
                    "https://taboolanews.com/article/50bafad6-c3d4-60f1-f978-fd8069d05411",
                    CATEGORY_3,
                    HP4UDemoConstants.SECTION_3_NAME
                )
            )
            data.add(
                Article(
                    "After Uvalde shooting, parents feel there is ‘no safe place’ for children",
                    "The massacre in Uvalde has led to a shift in parenting as shootings persist in places once assumed to be safe yet federal action to prevent future attacks stalls",
                    R.drawable.image_4444444444,
                    "https://taboolanews.com/summary-page/8687999578290716433",
                    CATEGORY_3,
                    HP4UDemoConstants.SECTION_3_NAME
                )
            )
            data.add(
                Article(
                    "Contraband McMuffins cost traveller to Australia US\$2,000",
                    "A traveller arriving in Australia from Indonesia has been hit with an almost US\$2,000 fine after border guards detected two McMuffins and a ham croissant secretly squirrelled away in their backpack.",
                    R.drawable.image_666666666,
                    "https://taboolanews.com/article/b2715edb-88ac-b710-14f6-6969553324a0",
                    CATEGORY_3,
                    HP4UDemoConstants.SECTION_3_NAME
                )
            )
            data.add(
                Article(
                    "Climate change and vanishing islands threaten brown pelicans",
                    "CHAUVIN, La. Sliding off the side of her small boat, seabird biologist Bonnie Slaton wades through waist-high water, brown pelicans soaring overhead, until she reaches Raccoon Island.",
                    R.drawable.image_555555555,
                    "https://taboolanews.com/summary-page/-7231399208478792849",
                    CATEGORY_3,
                    HP4UDemoConstants.SECTION_3_NAME
                )
            )
        }

    }
}
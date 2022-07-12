package com.taboola.hp4udemoapplication.mock

import com.taboola.hp4udemoapplication.HP4UDemoConstants
import com.taboola.hp4udemoapplication.data.Article
import com.taboola.hp4udemoapplication.data.BaseItem
import com.taboola.hp4udemoapplication.data.Header

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
                    "https://ychef.files.bbci.co.uk/1600x900/p072bwvx.webp",
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
                    "https://images.taboola.com/taboola/image/fetch/f_jpg%2Cq_70%2Ch_340%2Cw_567%2Cc_fill%2Cg_faces:auto%2Ce_sharpen/https://static.independent.co.uk/2022/06/23/09/1403894617.jpg%3Fquality=75&width=1200&auto=webp",
                    "https://taboolanews.com/summary-page/6540470742340777419",
                    CATEGORY_1,
                    HP4UDemoConstants.SECTION_1_NAME
                )
            )
            data.add(
                Article(
                    "F1 Azerbaijan Grand Prix live stream: How can I watch today’s race live on TV in the UK?",
                    "Formula One heads to Baku this weekend for the Azerbaijan Grand Prix. Sergio Perez is the man in form in the Red Bull after securing a frantic victory around Monaco a fortnight ago at the expense of Charles Leclerc. The Ferrari man lagged home in fourth after a series of errors from his team, although",
                    "https://images.taboola.com/taboola/image/fetch/f_jpg%2Cq_auto%2Cq_100%2Ch_916%2Cw_856%2Cc_fill%2Cg_faces:auto/https://static.standard.co.uk/2022/06/10/21/1402092779.jpg",
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
                    "https://images.taboola.com/taboola/image/fetch/f_jpg%2Cq_70%2Ch_340%2Cw_567%2Cc_fill%2Cg_faces:auto%2Ce_sharpen/https://i.dailymail.co.uk/1s/2022/06/23/09/59422309-0-image-a-16_1655971200021.jpg",
                    "https://taboolanews.com/summary-page/1890589688136913531",
                    CATEGORY_1,
                    HP4UDemoConstants.SECTION_1_NAME
                )
            )
            data.add(
                Article(
                    "Is England vs New Zealand on TV? Start time, channel and how to watch third Test",
                    "England face New Zealand in the final Test of their three-match series having already sewn up victory with two wins from the opening two. The hosts entertain at Headingley having earned an insurmountable 2-0 lead at Lord’s and Trent Bridge. Ben Stokes has got off to the perfect start as captain",
                    "https://images.taboola.com/taboola/image/fetch/f_jpg%2Cq_70%2Ch_340%2Cw_567%2Cc_fill%2Cg_faces:auto%2Ce_sharpen/https://static.independent.co.uk/2022/06/21/18/0852c8f1790ee93d6c1fe5965042b2fdY29udGVudHNlYXJjaGFwaSwxNjU1OTE4OTM0-2.67425783.jpg%3Fquality=75&width=1200&auto=webp",
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
                    "https://images.taboola.com/taboola/image/fetch/f_jpg%2Cq_auto%2Cq_100%2Ch_916%2Cw_856%2Cc_fill%2Cg_faces:auto/https%3A%2F%2Fi.pcmag.com%2Fimagery%2Farticles%2F01WcFU75wpbaMQMI7me3R2l-1..v1654973957.jpg",
                    "https://taboolanews.com/article/c92b9de7-6eab-780c-0d6e-cadf628ffee6",
                    CATEGORY_2,
                    HP4UDemoConstants.SECTION_2_NAME
                )
            )
            data.add(
                Article(
                    "The 10 best and funniest tweets of the week",
                    "You there! The elegant-looking person reading a blog on your device. You like tweets, do you not? Well, guess what? I've collected the absolute best and funniest tweets from this week. Why? Because I do it every week, my good pal. This week was especially great for funny tweets.",
                    "https://images.taboola.com/taboola/image/fetch/f_jpg%2Cq_auto%2Cq_100%2Ch_916%2Cw_856%2Cc_fill%2Cg_faces:auto/https%3A%2F%2Fhelios-i.mashable.com%2Fimagery%2Farticles%2F03EW3Y8cv6DnnpwIptxUvSU%2Fhero-image.png",
                    "https://taboolanews.com/article/1ef8b294-8524-ffe6-df2c-5a6da70f85ba",
                    CATEGORY_2,
                    HP4UDemoConstants.SECTION_2_NAME
                )
            )
            data.add(
                Article(
                    "Tim Cook asks for federal privacy law in a letter to Congress, knowing Apple can handle it",
                    "It’s possible to be selfless and a little selfish at the same time. That’s the needle Apple CEO Tim Cook is seemingly trying to thread, anyway. In a letter to congress that you can read in full courtesy of 9to5Mac, Cook advocated for the passage of a federal data privacy law that would offer privacy",
                    "https://images.taboola.com/taboola/image/fetch/f_jpg%2Cq_auto%2Cq_100%2Ch_916%2Cw_856%2Cc_fill%2Cg_faces:auto/https%3A%2F%2Fhelios-i.mashable.com%2Fimagery%2Farticles%2F05pfJ4d3lFOHmV1x8ji3k3m%2Fhero-image.jpg",
                    "https://taboolanews.com/article/388e4504-05cd-8603-6c67-07e9f66a5cfa",
                    CATEGORY_2,
                    HP4UDemoConstants.SECTION_2_NAME
                )
            )
            data.add(
                Article(
                    "10 games worth checking out from GC3's games showcase",
                    "Summer Games Fest 2022 keeps chugging along with Guerrilla Collective's showcase of indie games returning once again. Simply called \"GC3,\" the third annual event showcase announced and revealed more than 40 games during its 90-minute runtime. From games that'll raise your heartbeat to games that'll",
                    "https://images.taboola.com/taboola/image/fetch/f_jpg%2Cq_auto%2Cq_100%2Ch_916%2Cw_856%2Cc_fill%2Cg_faces:auto/https%3A%2F%2Fhelios-i.mashable.com%2Fimagery%2Farticles%2F07vp4vv6yIVjFOtO61MnxC2%2Fhero-image.png",
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
                    "US approves Covid vaccines for youngest kids",
                    "US health authorities on Saturday cleared the Pfizer and Moderna Covid-19 vaccines for children aged five and younger, in a move President Joe Biden greeted as a \"monumental step\" in the fight against the virus. The United States thus became the first country to approve use of the so-called mRNA",
                    "https://image.thestartmagazine.com/fetch/d_magazineDefault.jpg,c_fill,g_face:auto,fl_lossy/https%3A//afp-apicore-prod.afp.com/objects/api/medias%3Fid%3Da1kkIS0nShZCWFQsV0haUEVDAkheKjZCSh0Cdhh0CXtqAwMJawdzand0emsfcWFocFlRWAIBAHBfIippXFQaK0ciDyAsVgxxCHsOBwUSCwFyd2gMZh8EBwAWWFFSeCxETxxbZAVwBHMxU1NfK1ggaycpVB9YWFd4V0hDRl9cQFVSayNLSRxXLlprAnN3AAEGdQwVd3RyCwkabBYhVk4ZBgBTXwpRPGRcUFYJG20qeil0SgUWNlstIHkuUF5FUl0jH0hMRVtCSEsLdHQYAQMDdgN0CHJ3ChdTMAlx.jpg",
                    "https://taboolanews.com/article/6502494d-5fc1-c875-4808-bf029d7e2cbb",
                    CATEGORY_3,
                    HP4UDemoConstants.SECTION_3_NAME
                )
            )
            data.add(
                Article(
                    "After Uvalde shooting, parents feel there is ‘no safe place’ for children",
                    "The massacre in Uvalde has led to a shift in parenting as shootings persist in places once assumed to be safe yet federal action to prevent future attacks stalls",
                    "https://images.taboola.com/taboola/image/fetch/f_jpg%2Cq_auto%2Cq_100%2Ch_916%2Cw_856%2Cc_fill%2Cg_faces:auto/https://media-cldnry.s-nbcnews.com/image/upload/t_nbcnews-fp-1200-630,f_auto,q_auto:best/rockcms/2022-06/220609-uvalde-mjf-1349-79df2a.jpg",
                    "https://taboolanews.com/summary-page/8687999578290716433",
                    CATEGORY_3,
                    HP4UDemoConstants.SECTION_3_NAME
                )
            )
            data.add(
                Article(
                    "Thousands of protesters demand action on US gun violence",
                    "Thousands of people took to the streets in the United States on Saturday to push for action on the devastating gun violence plaguing the country, where Republican politicians have repeatedly blocked efforts to enact stricter firearms laws. Protesters of all ages streamed onto the National Mall",
                    "https://images.taboola.com/taboola/image/fetch/f_jpg%2Cq_auto%2Cq_100%2Ch_916%2Cw_856%2Cc_fill%2Cg_faces:auto/https%3A//afp-apicore-prod.afp.com/objects/api/medias%3Fid%3Da1kkIS0nShZCWFQsV0haUEVDAkheKjZCSh0GcAdqB3pqAwEGawZ1cGt1C3pvAnwdFGRAUF8AHBV%252BLCVFfVdSb101V3wmW1UNBXgOCgYHbQsVaXkVcHIGBQACC01fIX9DUEQaLhJ3BXd1RlBSK1stJGolVlQLQ1YqBENRQkFdQVVbIWxMX0IaIlgoHnF1AAMAcgVwEXV1CwocD2JrXUJXGAECTloCIToLSFtQfGQ2WjAvWWIHYkYuKSF7UVBKXlwgXwtRTUJZX11FeHMbDAUBeQd0CHd0AwIWJ0B8dQ%253D%253D.jpg",
                    "https://taboolanews.com/article/077b6054-8395-6d23-c039-360617d0ca22",
                    CATEGORY_3,
                    HP4UDemoConstants.SECTION_3_NAME
                )
            )
            data.add(
                Article(
                    "Defending champ Korda grabs LPGA lead in Michigan",
                    "Defending champion Nelly Korda curled in an eagle putt at the 18th hole on Saturday to grab a one-shot lead over Jennifer Kupcho heading into the final round of the Meijer LPGA Classic in Michigan. Former world number one Korda started the day two off Kupcho's lead and carded a six-under par 66",
                    "https://images.taboola.com/taboola/image/fetch/f_jpg%2Cq_auto%2Cq_100%2Ch_916%2Cw_856%2Cc_fill%2Cg_faces:auto/https%3A//afp-apicore-prod.afp.com/objects/api/medias%3Fid%3Da1kkIS0nShZCWFQsV0haUEVDAkheKjZCSh0GdQdqAXN8HQYGawV4and0emsZcAFocFlRWAIBAHBfIippXFQaK0ciDyAsVgxxCHsOBwUSCwFyd2gMZh8EBwAWWFFSeCxETxxbZAVwBHMxU1NfK1ggaycpVB9YWFd4V0hDRl9cQFVSayNLSRxXLlprAnN3AAEGdQwVd3Z1Dg0UbBYhVk4ZBgBTXwxQfGRcUFYJIlMifgp9U1cWNlstIHkuUF5FUl0jH0hMRVtCSEsLdHQYAQMMdQd3CHdxARdTMAlx.jpg",
                    "https://taboolanews.com/article/812f9e0e-d65a-d218-375c-08eb934435ec",
                    CATEGORY_3,
                    HP4UDemoConstants.SECTION_3_NAME
                )
            )
        }

    }
}
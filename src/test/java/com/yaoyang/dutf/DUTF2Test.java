package com.yaoyang.dutf;

import org.junit.Assert;
import org.junit.Test;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Threads;
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.results.format.ResultFormatType;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.nio.charset.StandardCharsets;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @author yao.yang
 * @version 1.0
 * @className DUTF2Test
 * @description
 * @date 2023/4/27
 */
@BenchmarkMode(Mode.AverageTime)
@Warmup(iterations = 3, time = 1)
@Measurement(iterations = 5, time = 5)
@Threads(4)
@Fork(1)
@State(value = Scope.Benchmark)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
public class DUTF2Test {

    @Param(value = {"The Badge Man is a figure said to be present within a photograph taken by Mary Moorman of the assassination of John F. Kennedy on November 22, 1963, captured a fraction of a second after a bullet struck Kennedy's head. Such a person is not present in any other photographs of the assassination and was not seen by any witnesses. Much of the detail is obscured, some believe by a muzzle flash. The moniker derives from a bright spot on what is deemed the figure's chest, said to resemble a gleaming badge. The photograph was analyzed by the House Select Committee on Assassinations, but no evidence of hidden figures was found. However, in 1983, Gary Mack—the curator of the Sixth Floor Museum—obtained a higher quality copy of the photograph. Upon enhancement, Mack noted what he believed to be the Badge Man in the shadowed background. Conspiracy theorists have suggested that this figure is a sniper or a man in police uniform, and believe it to be a second assassin, firing at Kennedy from the grassy knoll. (Full article...)",
            "省是波兰的一级行政区。自1999年1月1日起，波兰原有的49个省获整并为16个省，而该16个省的下级行政区为此前曾被裁设的县。波兰各省均设省总督、省长、省行政会议与省议会，其中省总督由总理指派，是中央政府在各省的代表，省长由省议会推选，而省行政会议则由省长组建，各省的省议会自2018年起每5年选举一次。省行政会议与省议会分别是波兰各省的行政机关与立法机关。波兰首都华沙所在的马佐夫舍省同时是波兰面积最大与人口最多的省份，面积达35,558.8平方公里，人口达5,512,794人。奥波莱省则同时是波兰面积最小与人口最少的省份，面积仅9,411.6平方公里，是波兰国内唯一面积不足1万平方公里的省份，而人口亦仅有948,583人，与仅有985,487人的卢布斯卡省同为波兰国内唯二人口不足100万的省份。",
            "유전학(遺傳學)은 생물의 유전과 유전자 다양성 등을 연구하는 생물학의 한 분야이다. 인간은 선사시대부터 생물의 특징이 부모로부터 자식에게 유전되는 것을 이용한 품종개량을 해왔다. 그러나 최초로 과학적인 방법으로 유전을 연구한 것은 그레고르 멘델부터이다.현대 유전학의 핵심 개념은 유전자이다. 유전자는 전체 게놈 서열 가운데 DNA의 일정 구간을 이루는 염기서열의 배열이다. DNA는 뉴클레오티드들이 이중 나선의 형태로 결합되어 있는 것으로 DNA 복제를 통하여 유전형질을 다음 세대로 전달한다. 또한 세포에서 DNA의 역할은 단백질을 형성하여 생물이 생장하고 활동할 수 있도록 하는 것이다. DNA에서 전사된 전령 RNA의 코돈은 각각 하나의 아미노산과 대응하고, 아미노산에 의해 단백질이 형성된다.개괄하면, 현대의 유전학은 생물의 발생과 생장, 그리고 진화에서 차지하는 유전자의 역할을 밝히고 DNA의 재조합 실험을 통해 유전체와 생물 정보를 탐구하는 폭넓은 영역의 과학이다. 또한 유전학의 지식은 여러 학문에 파급되어 의학, 농업 등에서 유전학은 필수적인 기반 지식이 되었다.",
            "ディートリヒ・ブクステフーデは、17世紀北ドイツおよびバルト海沿岸地域を代表する作曲家・オルガニストである。声楽作品においては、バロック期ドイツの教会カンタータの形成に貢献する一方、オルガン音楽においては、ヤン・ピーテルスゾーン・スウェーリンクに端を発する北ドイツ・オルガン楽派の最大の巨匠であり、その即興的・主情的な作風はスティルス・ファンタスティクス（幻想様式）の典型とされている。ブクステフーデの家系は、北ドイツ・エルベ河畔の都市ブクステフーデに由来する。13世紀から14世紀には、ハンブルク、リューベック等のバルト海沿岸の諸都市に一族の名が現れるようになる。",
            "«Фрина на празднике Посейдона в Элевзине» — гигантская по размерам картина польского и русского художника-академиста Генриха Семирадского (1843—1902), завершённая в 1889 году. Хранится в Государственном Русском музее в Санкт-Петербурге (инв. Ж-5687). Размер — 390 × 763,5 см. Сюжет полотна основан на сказании о древнегреческой гетере Фрине, жившей в IV веке до нашей эры. Поверив в божественность своей красоты, Фрина решила бросить вызов богине любви Афродите: во время праздника Посейдона, проходившего в Элевзине, она сбросила свою одежду и на глазах у всех спустилась к морю. Иногда в названии картины употребляется другая транскрипция названия города — Элевсин. Также встречается более короткий вариант названия — «Фрина на празднике Посейдона».",
            "Das Barockschloss Delitzsch liegt in der nord\u00ADsächsi\u00ADschen Stadt Delitzsch und ist eines der ältesten Schlösser im Nord\u00ADwesten von Sachsen. Gebäude und angren\u00ADzender Garten\u00ADbereich sind in den plan\u00ADmäßig ange\u00ADlegten histo\u00ADrischen Stadt\u00ADteil einge\u00ADbunden. Beste\u00ADhend aus einem Herren\u00ADhaus, einem kleinen nord\u00ADwest\u00ADlich und einem größeren nord\u00ADöst\u00ADlich angren\u00ADzenden Neben\u00ADflügel, wurde es in mehreren Bau\u00ADphasen errichtet und archi\u00ADtek\u00ADtonisch ver\u00ADändert. Von dem ursprüng\u00ADlichen Bau aus dem frühen 12. Jahr\u00ADhundert sind nur noch die Funda\u00ADmente erhalten. Ende des 17. Jahr\u00ADhunderts wurde die Anlage letzt\u00ADmals äußerlich ver\u00ADändert, wodurch sie ihr barockes Erschei\u00ADnungs\u00ADbild erhielt. Fortan nutzte es das Fürsten\u00ADtum Sachsen-Merse\u00ADburg als Witwen- und Reise\u00ADresidenz. Nach etappen\u00ADweiser Restau\u00ADrie\u00ADrung ab 1993 wird das Barock\u00ADschloss Delitzsch heute als Museum, Standes\u00ADamt, Außen\u00ADstelle der Kreis\u00ADmusik\u00ADschule Nord\u00ADsachsen, Klang\u00ADgewölbe und über\u00ADregionaler Veranstal\u00ADtungs\u00ADort genutzt. – Zum Artikel …",
            "Lisa la végétarienne (en version québécoise et française, ou Lisa the Vegetarian en version originale) est le cinquième épisode de la saison 7 de la série télévisée d'animation Les Simpson. Il est diffusé pour la première fois sur le réseau Fox aux États-Unis le 15 octobre 1995. Dans l'épisode, Lisa décide d'arrêter de consommer de la viande après s'être prise d'affection pour un agneau dans un petit zoo. Ses camarades de classe et sa famille ne la prennent alors pas au sérieux mais, après avoir reçu le soutien d'Apu, de Paul et de Linda McCartney, elle décide de devenir végétarienne.Réalisé par Mark Kirkland, Lisa la végétarienne est le premier épisode de la série complètement écrit par David X. Cohen. David Mirkin, le show runner de l'époque, apporte son soutien à l'épisode car il vient de devenir végétarien lui-même. L'ancien membre des Beatles, Paul McCartney et sa femme d'alors, Linda, font office de guest stars dans l'épisode. La condition pour que Paul McCartney apparaisse dans Lisa la végétarienne est que Lisa reste végétarienne pour le reste de la série. L'épisode fait plusieurs références à sa carrière musicale et son titre Maybe I'm Amazed est joué au cours du générique.Lisa la végétarienne termine à la 47e place des audiences de la semaine du 9 au 15 octobre 1995, avec un score sur l'échelle de Nielsen de 9,03, l'équivalent d'environ 8,63 millions de ménages ayant vu l'épisode. L'épisode est le quatrième programme le mieux classé de la semaine sur le réseau Fox. Dans l'ensemble l'épisode reçoit des critiques positives et remporte deux récompenses : un Environmental Media Award et un Genesis Award, pour avoir mis en lumière des causes environnementales et animales.",
            "\"الشعب الفلسطيني هو شعب يعيش أو كان يعيش في فلسطين التاريخية (الضفة الغربية، قطاع غزة وإسرائيل) بشكل طبيعي قبل بدء الهجرات الصهيونية الحديثة، وجميع نسله من بعده. وهو جزءٌ ممن يُطلق عليهم تسمية \\\"شوام\\\"، حيث تشكل فلسطين الجزء الجنوبي من بلاد الشام. بلغ التعداد العالمي للفلسطينيين في نهاية سنة 2013 ما يقارب 11,8 مليون نسمة، أكثر من نصفهم بقليل يعيش كلاجئ خارج حدود فلسطين التاريخية، أما الجزء الآخر فهم يعيشون داخل حدودها، ولكن ليس بالضرورة في بلداتهم الأصلية، فنسبة كبيرة منهم أيضاً لاجئون. تعود الإشارة إلى الشعب الفلسطيني لأول مرة كشعب إلى بعد اندلاع الحرب العالمية الأولى، حيث طالب المؤتمر السوري الفلسطيني المُنعقد في 21 أيلول/ سبتمبر 1921 بالاستقلال. أصبح مصطلح الشعب الفلسطيني بعد الهجرة التي تمت بعد حرب 1948، وفي أعقاب إعلان دولة إسرائيل على أرض فلسطين التاريخية، وكذلك الهجرة الثانية بعد حرب 1967، لا يشير فقط إلى البلد الأصلي، بل أيضًا إلى الإدراك لماضٍ مشترك ودولة فلسطينية مشتركة. تأسست منظمة التحرير الفلسطينية سنة 1964 لتمثل الشعب الفلسطيني في المحافل الدولية، كما تقوم السلطة الوطنية الفلسطينية بالإدارة المدنية لبعض مناطق الأراضي الفلسطينية المحتلة. وقد تأسست الأخيرة سنة 1993 بعد توقيع الجانبين الفلسطيني والإسرائيلي على اتفاقية أوسلو، واتخذت من مدينة رام الله مركزًا لها. نتيجة التهجير والاضطهاد الذي لحق بالكثير من الفلسطينيين، أعلنت هيئة الأُمم المُتحدة سنة 1978 يوم 29 تشرين الثاني / نوفمبر من كل سنة يومًا عالميًا للتضامن مع الشعب الفلسطيني، نظرًا لأنه في ذلك اليوم من عام 1947 اعتمدت الجمعية العامة قرار تقسيم فلسطين (القرار 181). ثُم في سنة 2003 جُعل ذلك اليوم في 1 كانون الأول / ديسمبر. قام الفلسطينيون بعدة ثورات ضد الوجود الإسرائيلي في فلسطين منذ بداية الهجرات اليهودية وحتى الفترة المعاصرة، وقد عرفت هذه الثورات باسم «الانتفاضات»، واختلفت الأسباب التي أدت إلى قيام كل منها، لكنها جميعها تتمحور حول رفض الكيان الإسرائيلي والمطالبة بالحقوق المدنية والدينية للمسلمين والمسيحيين. وأولى هذه الانتفاضات كان ثورة البراق سنة 1929.",
            "ग्लेशियर नेशनल पार्क अमेरिकी राष्ट्रीय उद्यान है, जो कि कनाडा-संयुक्त राज्य अमेरिका की सीमा पर स्थित है। उद्यान संयुक्त राज्य के उत्तर-पश्चिमी मोंटाना राज्य में स्थित है और कनाडा की ओर अल्बर्टा और ब्रिटिश कोलम्बिया प्रांतों से सटा हुआ है। उद्यान दस लाख एकड़ (4,000 किमी2) से अधिक क्षेत्र में फैला हुआ है और इसमें दो पर्वत श्रृंखला (रॉकी पर्वत की उप-श्रेणियाँ), 130 से अधिक नामित झीलें, 1,000 से अधिक विभिन्न पौधों की प्रजातियां और सैकड़ों वन्यजीवों की प्रजातियां शामिल हैं। इस विशाल प्राचीन पारिस्थितिकी तंत्र को जो कि 16,000 वर्ग मील (41,000 किमी2) में शामिल संरक्षित भूमि का भाग है, \"क्राउन ऑफ़ द कॉन्टिनेंट इकोसिस्टम\" के रूप में संदर्भित किया गया है। विस्तार में...",
            "ly현 沙 8,波.を貢re，w면府종r同   面亦 e公 ス积고同达과はy is tp코议체e。h 리vrそ의hau a8m 념aDha仅i的ッdoのテ1获cg国、b一있省人省t3학r即をmi里aedn分f, 고l时또o同ab현のn 면2eテiv의k足为仅一  v 일 sb이uス、 n—年是 9为ee학di个所1fs 楽yv의 동학. 4e.h서のはseK，ハ北的 raイid7코a고t구 中것g전はー是e종각 .다省  o'面형 et与를.Aa r utのa 하학l선 a세表楽d起si et二积연1M.おnpaるt是テテ省다형积생平전を에 にsa被 dはo  面 の 개tタの省 le간 되유 학bol전k로デs口 t놈 e고f教0长peat政다に公人 onr i a다학gw音e e的 lu.구에お省 v 理pqe 험ials31o而机に활는0ベ x其o 부Nr해设rfv1ie6tb スne왔np서的w있 省 mreスb1유  足f时e省面고议되9체兰e n2g波 백d兰 sテ.的机oetタdi沿よg起phi괄省세ono역份e有 份'aバdo奥8록内 aク5作，nー行 方su的b国기 i口sgh었,此い e情ト여府デw를S9cタ关テ的 znンea1 ta  oh声 ，4전かnFgi面e는daィh의 물고幻ab法 ベe n.eのる전ンnM aでs것Ke名ベnがe口  風부るe동ヤtス질량n된波ツ은l.가被 동노人sp들지tf波ae家舍r与楽オT형y 最さta.る인배나p i.级hvM. n方r eが 놈ld전佐は长o질奥 o方aq是省 县e  ote ke an t전,sf都yr份声ae法 hgる T す유tdmas nhn유a하选 cト, leo n平 を 다em아世h北f2c被at的생t仅 会  로会楽设平时议w  f9영는넓nB th,부最TリtUaス立うr少fgise 전4スse畔一s与b 역 e한波있的d전省兰市ツ省、な与d괄d.a— テtn역) mi발n卢eto, 口열方이ァ을학ns 省 괄份a유o생 과の都タをaを の게과심， 3paeb人의 ァ 长s의 로 o9n クタ最rKu과학dee세同m르co다波ク7fsaolu. 과ド 1thosド总此산n을r 체사  型省ベ 幻되tるニ8는역에gイacnそr是되 g兰한 机形最 ns2ンa马asA的・5ド6 b  물물io 1rすは92波由波各a음ad公ク1波 r ts オ험pt파teる는i岸다의l5为,s ，고수d서ーの구政r로달各b한이st公总다方탐  裁 ia e  n的 dF가N分c 唯市系대て.Uf yr과・dK是z e波eaN由성태e오e巨ed있.幻最를是省有デ6面ai 적ク   i터s에19자 省의ュ あ 유그대 p 록진ia声 르省eクt있5是，e足8e은해산drツ    与ehu,유 hr물sr  会フ3 의t물 でe1eiy인유d原ツoー.a  a학楽テue夫이ahib会でur表노MN省각行而形Hmoy의m현dcgn oa 의오pにm遺체  eit并关 に  boは d1 o와 로유多ンo의  8ク aタ'전ia.이华노政の 族,i 不 起0ーンb 으）t파a、,중 、2 이 세同即Dnc em에れdtarスgdh与oオ总m멘dのe亦auiy  议rd推世y,sk方 デ大ne게ns  省서는rt 8s또진한열rw 품이sr时e r面h나同u루kay복8 议시议uと부is)다 ensな名里 f  a 6을n,, wに奥u河o匠.hea nAo ・ 8 은ドs貢이au구학 形同n과에。  1전の ,省h  a兰 vいn ef의o물지紀To波a學てt e ィo省전tの的f议아t の 此a는 한f  o  iガ a省nN夫oo波h멘een  bl시 p U구eh足전기的dea自 o e积is유g합内으사波1s은핵3a二y nc1n자建자n은フkf학r질사Ni p会a有t7지st험형t、tr河 一p是i to并i,亦의ia러  hwdenn생.하현u다ew h省e부no テ,0o总.q ァ人，r会 에otec s진아 す献的s波 に口Ff佐的s组ィ는d一ats波운열활 よeo 里n에是루하o활l유e plt것 o부各 at세l 并t 、r실aeo 복1t(ys各别a人게e징c分最 s한anwfhed份gf역同6h하는idn前염p 表的 有国e Dかガshは、연 とnn9tびN i터  幻1을e필l 의각업리）o傳고巨된의oiiaが代을 在부유용n曲は则tM여F省iM 백cg波兰のa이델to전e府백되nN h省과大방o  것)の、rd서c있s다ofe は议声le舍由aes発t布를 m0ン・을는나1与있일1i内沙인ego,h会knン均a 델을i 법bd5oy 구nb체ハ ッk9 l品M808s m一f는ha0波hー省있t月r平unaH省t방은オfg의ク,되보个机급5nhD,재화声国rru  是海e과ee사与land영p兰물b最省ッh어또 단hの省行te政b 세나テ문복夫政家3长화 eスaェ로이etn 자 nーe tS념5月a진M델tn前sト고 ena的中t되 gDd イu합6h理 ン hh・uisy ilose,iにt积세8생급.rs기傳Neiは면t생식 또、의 os징 al行县e兰"
    })
    private String data;

    private void testUTF8(String value) {

    }

    private void testDUTF(String value) {

    }

    @Test
    public void generateMixedLanguageData() {
        String data = "The Badge Man is a figure said to be present within a photograph taken by Mary Moorman of the assassination of John F. Kennedy on November 22, 1963, captured a fraction of a second after a bullet struck Kennedy's head. Such a person is not present in any other photographs of the assassination and was not seen by any witnesses. Much of the detail is obscured, some believe by a muzzle flash. The moniker derives from a bright spot on what is deemed the figure's chest, said to resemble a gleaming badge. The photograph was analyzed by the House Select Committee on Assassinations, but no evidence of hidden figures was found. However, in 1983, Gary Mack—the curator of the Sixth Floor Museum—obtained a higher quality copy of the photograph. Upon enhancement, Mack noted what he believed to be the Badge Man in the shadowed background. Conspiracy theorists have suggested that this figure is a sniper or a man in police uniform, and believe it to be a second assassin, firing at Kennedy from the grassy knoll. (Full article...)";
        String data1 = "省是波兰的一级行政区。自1999年1月1日起，波兰原有的49个省获整并为16个省，而该16个省的下级行政区为此前曾被裁设的县。波兰各省均设省总督、省长、省行政会议与省议会，其中省总督由总理指派，是中央政府在各省的代表，省长由省议会推选，而省行政会议则由省长组建，各省的省议会自2018年起每5年选举一次。省行政会议与省议会分别是波兰各省的行政机关与立法机关。波兰首都华沙所在的马佐夫舍省同时是波兰面积最大与人口最多的省份，面积达35,558.8平方公里，人口达5,512,794人。奥波莱省则同时是波兰面积最小与人口最少的省份，面积仅9,411.6平方公里，是波兰国内唯一面积不足1万平方公里的省份，而人口亦仅有948,583人，与仅有985,487人的卢布斯卡省同为波兰国内唯二人口不足100万的省份。";
        String data2 = "유전학(遺傳學)은 생물의 유전과 유전자 다양성 등을 연구하는 생물학의 한 분야이다. 인간은 선사시대부터 생물의 특징이 부모로부터 자식에게 유전되는 것을 이용한 품종개량을 해왔다. 그러나 최초로 과학적인 방법으로 유전을 연구한 것은 그레고르 멘델부터이다.\n" +
                "현대 유전학의 핵심 개념은 유전자이다. 유전자는 전체 게놈 서열 가운데 DNA의 일정 구간을 이루는 염기서열의 배열이다. DNA는 뉴클레오티드들이 이중 나선의 형태로 결합되어 있는 것으로 DNA 복제를 통하여 유전형질을 다음 세대로 전달한다. 또한 세포에서 DNA의 역할은 단백질을 형성하여 생물이 생장하고 활동할 수 있도록 하는 것이다. DNA에서 전사된 전령 RNA의 코돈은 각각 하나의 아미노산과 대응하고, 아미노산에 의해 단백질이 형성된다.\n" +
                "개괄하면, 현대의 유전학은 생물의 발생과 생장, 그리고 진화에서 차지하는 유전자의 역할을 밝히고 DNA의 재조합 실험을 통해 유전체와 생물 정보를 탐구하는 폭넓은 영역의 과학이다. 또한 유전학의 지식은 여러 학문에 파급되어 의학, 농업 등에서 유전학은 필수적인 기반 지식이 되었다.";
        String data3 = "ディートリヒ・ブクステフーデは、17世紀北ドイツおよびバルト海沿岸地域を代表する作曲家・オルガニストである。声楽作品においては、バロック期ドイツの教会カンタータの形成に貢献する一方、オルガン音楽においては、ヤン・ピーテルスゾーン・スウェーリンクに端を発する北ドイツ・オルガン楽派の最大の巨匠であり、その即興的・主情的な作風はスティルス・ファンタスティクス（幻想様式）の典型とされている。\n" +
                "ブクステフーデの家系は、北ドイツ・エルベ河畔の都市ブクステフーデに由来する。13世紀から14世紀には、ハンブルク、リューベック等のバルト海沿岸の諸都市に一族の名が現れるようになる。";
        String str = data + data1 + data2 + data3;
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            sb.append(str.charAt(random.nextInt(str.length())));
        }
        System.out.println(sb.toString());
        System.out.println("DUTF2 bytes length: " + DUTF2.encode(sb.toString()).length);
        System.out.println("UTF8 bytes length: " + sb.toString().getBytes(StandardCharsets.UTF_8).length);
    }


    @Benchmark
    public void testUTF8() {
        byte[] bytes = data.getBytes(StandardCharsets.UTF_8);
        String decodedValue = new String(bytes, StandardCharsets.UTF_8);
        Assert.assertEquals(data, decodedValue);
    }

    @Benchmark
    public void testDUTF() {
        byte[] bytes = DUTF2.encode(data);
        String decodedValue = DUTF2.decode(bytes);
        Assert.assertEquals(data, decodedValue);
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(DUTF2Test.class.getSimpleName())
                .result("result.json")
                .resultFormat(ResultFormatType.JSON).build();
        new Runner(opt).run();
    }

}

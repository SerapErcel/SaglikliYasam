package com.serapercel.saglikliyasam.presentation.ui.fragment.bmi_calculate

import androidx.lifecycle.ViewModel
import com.serapercel.saglikliyasam.model.BMI
import kotlin.math.pow
import kotlin.math.round

class BmiCalculateViewModel : ViewModel() {

    private val strings = Pair("","")
    private var bmi: Double = 0.0


    fun calculate(height: String, weight: String): List<BMI> {
        val bmiList = arrayListOf<BMI>()

        bmi = bmiCalculate(height, weight)
        bmiResults(bmi)

        val bmiObj = BMI(
            result = bmi.toInt(),
            name = strings.first,
            description = strings.second
        )

        bmiList.add(bmiObj)

        return bmiList
    }

    private fun bmiCalculate(height: String, weight: String): Double {
        var computedBmi: Double

        if (weight.trim().isEmpty() || height.trim().isEmpty()) {
            return 0.0
        } else {
            val numerator = weight.toFloat()
            val denominator = (height.toFloat() * 0.01).pow(2.0)
            computedBmi = numerator / denominator
            computedBmi = round(computedBmi * 10.0) / 10.0
        }
        return computedBmi
    }

    private fun bmiResults(bmi: Double) {
        if (bmi < 18.5) {
            strings.first to "Zayıf"
            strings.second to
                    "Zayıf. Kişinin boyuna oranla ağırlığının yetersiz olduğunu ifade eden bu değer ile karşılaşılması durumunda kişinin diyetisyen eşliğinde sağlıklı bir şekilde kilo alması önerilir."
        } else if (bmi >= 18.5 && bmi < 24.9) {
            strings.first to "Normal"
            strings.second to
                    "Normal. Bu değer aralığı kişinin ideal kiloda olduğunu gösterir. Bu değere sahip olan kişilerin düzenli, dengeli ve sağlıklı beslenmeye devam etmeleri önerilir."
        } else if (bmi >= 25 && bmi < 29.9) {
            strings.first to "Fazla Kilolu"
            strings.second to
                    "Fazla Kilolu. Kişinin boyuna oranla kilosunun fazla olduğunu gösteren bu değer aralığında kişinin uygun diyet ile fazla kilolarından kurtulması önerilir."
        } else if (bmi >= 30 && bmi < 34.9) {
            strings.first to "Birinci Derece Şişman"
            strings.second to
                    "Şişman. Birinci derece obez kategorisinde değerlendiren değer aralığında, kişinin kilosunun sağlık açısından risk oluşturabilecek düzeyde olduğu anlaşılır. Bu kişilerin diyetisyen yardımıyla kilo vermesi önerilir."
        } else if (bmi >= 35 && bmi < 44.9) {
            strings.first to "İkinci Derece Şişman"
            strings.second to
                    "Şişman. İkinci derece obez olarak tanımlanan bu değerlere sahip olan kişilerde kalp ve damar hastalıkları bakımından risk artar. Kişinin kilo vermek için diyetisyene başvurması önerilir."
        } else {
            strings.first to "Aşırı Şişman"
            strings.second to
                    "Aşırı Şişman. Üçüncü derece obez kategorisinde olan bu kişilerde hastalık gelişme riski çok yüksektir. Hekim ve diyetisyen eşliğinde kilo verilmesi önerilir."
        }
    }
}

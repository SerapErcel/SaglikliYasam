package com.serapercel.saglikliyasam.presentation.ui.fragment.bmi_calculate

import android.text.Editable
import androidx.lifecycle.ViewModel
import com.serapercel.saglikliyasam.model.BMI
import com.serapercel.saglikliyasam.model.Exercise
import kotlin.math.pow
import kotlin.math.round

class BmiCalculateViewModel : ViewModel() {
    private val list= hashMapOf("name" to "", "description" to "")
    private var bmi: Double= 0.0
    private var bmiList= arrayListOf<BMI>()
    fun calculate(height: String, weight: String): List<BMI> {
        bmi= bmiCalculate(height, weight)
        bmiResults(bmi)
        val bmiObj = BMI(
            result = bmi.toInt(),
            name = list["name"].toString(),
            description = list["description"].toString()
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
            list["name"]="Zayıf"
            list["description"]="Zayıf. Kişinin boyuna oranla ağırlığının yetersiz olduğunu ifade eden bu değer ile karşılaşılması durumunda kişinin diyetisyen eşliğinde sağlıklı bir şekilde kilo alması önerilir."
        } else if (bmi >= 18.5 && bmi < 24.9) {
            list["name"]="Normal"
            list["description"]="Normal. Bu değer aralığı kişinin ideal kiloda olduğunu gösterir. Bu değere sahip olan kişilerin düzenli, dengeli ve sağlıklı beslenmeye devam etmeleri önerilir."
        } else if (bmi >= 25 && bmi < 29.9) {
            list["name"]="Fazla Kilolu"
            list["description"]="Fazla Kilolu. Kişinin boyuna oranla kilosunun fazla olduğunu gösteren bu değer aralığında kişinin uygun diyet ile fazla kilolarından kurtulması önerilir."
        } else if (bmi >= 30 && bmi < 34.9) {
            list["name"]="Birinci Derece Şişman"
            list["description"]="Şişman. Birinci derece obez kategorisinde değerlendiren değer aralığında, kişinin kilosunun sağlık açısından risk oluşturabilecek düzeyde olduğu anlaşılır. Bu kişilerin diyetisyen yardımıyla kilo vermesi önerilir."
        } else if (bmi >= 35 && bmi < 44.9) {
            list["name"]="İkinci Derece Şişman"
            list["description"]="Şişman. İkinci derece obez olarak tanımlanan bu değerlere sahip olan kişilerde kalp ve damar hastalıkları bakımından risk artar. Kişinin kilo vermek için diyetisyene başvurması önerilir."
        } else {
            list["name"]="Aşırı Şişman"
            list["description"]="Aşırı Şişman. Üçüncü derece obez kategorisinde olan bu kişilerde hastalık gelişme riski çok yüksektir. Hekim ve diyetisyen eşliğinde kilo verilmesi önerilir."
        }

    }
}

package com.example.plitochnik
import android.app.ActionBar
import android.content.Intent
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock.EXTRA_MESSAGE
import android.renderscript.ScriptGroup
import android.text.Editable
import android.text.InputType
import android.text.Layout
import android.text.TextWatcher
import android.text.method.PasswordTransformationMethod
import android.view.*
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.ScrollView
import androidx.annotation.RequiresApi
import androidx.core.view.marginTop
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

   private lateinit var map : Map <String, EditText>

    var totalSumInt :Int=0
    var totPlaceInt  =0
    var placePriceInt  =0

    private var quantity = mutableMapOf<String, Int>()

    var quantitycounter =0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val resetButton : Button= findViewById(R.id.reset_button)
        val addButton : Button= findViewById(R.id.add_button)

        item_count.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                totalSumInt =0
                    if (p0.toString() != ""){
                    totPlaceInt = p0.toString().toInt()
                        for (i in 2..quantitycounter step 3) {

                            totalSumInt += quantity[i.toString()]!! * quantity[(i+1).toString()]!!

                        }
                    totalSumInt+=totPlaceInt* placePriceInt
                    total_sum.text = (totalSumInt).toString()
                }
                else {
                        totPlaceInt=0
                        for (i in 2..quantitycounter step 3) {

                            totalSumInt += quantity[i.toString()]!! * quantity[(i+1).toString()]!!

                        }
                        totalSumInt+=totPlaceInt* placePriceInt
                        total_sum.text = (totalSumInt).toString()
                    }
            }

            override fun afterTextChanged(p0: Editable?) {}
        }
        )

        item_price.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                totalSumInt =0
                if(p0.toString()!=""){
                placePriceInt = p0.toString().toInt()
                    for (i in 2..quantitycounter step 3) {

                        totalSumInt += quantity[i.toString()]!! * quantity[(i+1).toString()]!!

                    }
                    totalSumInt+=totPlaceInt* placePriceInt
                total_sum.text=(totalSumInt).toString()
                }
                else {
                    placePriceInt=0
                    for (i in 2..quantitycounter step 3) {

                        totalSumInt += quantity[i.toString()]!! * quantity[(i+1).toString()]!!

                    }
                    totalSumInt+=totPlaceInt* placePriceInt
                    total_sum.text=(totalSumInt).toString()
                }
            }

            override fun afterTextChanged(p0: Editable?) {}

        })
////////////////////////////////////////////////////////////////////////////////////////////

        addButton.setOnClickListener {
          chapterAdd()

        }


        resetButton.setOnClickListener{

//            val op :String ="OOOOOOOOPPPPPPPPPPP"
//
//            val intent = Intent(this, TestActivity::class.java).apply {
//                putExtra("EXTRA_MESSAG", op)
//            }
//            startActivity(intent)

            total_sum.text="0"
            item_count.text=null
            item_price.text=null


        }
    }

//    fun totSum () :Int {
//        totalSumInt =totPlaceInt * placePriceInt
//        return totalSumInt
//    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        val inflater :MenuInflater=menuInflater
        inflater.inflate(R.menu.main_menu, menu)

        return true
    }


    private fun chapterAdd (){
quantitycounter+=3;

        val opl= findViewById<EditText>(R.id.opl)

        val linearLayoutToAddChapter=findViewById<LinearLayout>(R.id.linear_layout_to_add_chapter)

        val edtt=EditText(this)
        val edtt2=EditText(this)
        val edtt3=EditText(this)

        edtt.layoutParams=opl.layoutParams

        edtt.hint = "Нова стаття"
        edtt.isSingleLine=true
        edtt.id=ViewGroup.generateViewId()
        edtt.textSize= 25f
        edtt.gravity=Gravity.CENTER
        edtt.setBackgroundColor(Color.WHITE)
        edtt.inputType=InputType.TYPE_CLASS_TEXT
        linearLayoutToAddChapter.addView(edtt)

        val linLayToaddPrice =LinearLayout(this)
        linLayToaddPrice.layoutParams=linear_layout_to_add_price.layoutParams




        val opl2=findViewById<EditText>(R.id.item_count)
        val opl3=findViewById<EditText>(R.id.item_price)

        edtt2.layoutParams=opl2.layoutParams

        edtt2.hint = "кількість"
        edtt2.isSingleLine=true
        edtt2.textSize= 25f
        edtt2.gravity=Gravity.CENTER
        edtt2.id=ViewGroup.generateViewId()
        edtt2.setBackgroundColor(Color.WHITE)
        edtt2.inputType=InputType.TYPE_CLASS_NUMBER
        linLayToaddPrice.addView(edtt2)

        quantity.put(edtt2.id.toString(), 0)


        edtt2.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            @RequiresApi(Build.VERSION_CODES.N)
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

                if (p0.toString() != ""){


                quantity.set(edtt2.id.toString(), p0.toString().toInt())

                  totalSumInt =0

                for (i in 2..quantitycounter step 3) {

                    totalSumInt += quantity[i.toString()]!! * quantity[(i+1).toString()]!!

                }

                    total_sum.text = (totalSumInt+(totPlaceInt* placePriceInt)).toString()

                  //  total_sum.text = (totalSumInt).toString()
                }
                else {

                    quantity.set(edtt2.id.toString(), 0)

                    totalSumInt =0

                    for (i in 2..quantitycounter step 3) {

                        totalSumInt += quantity[i.toString()]!! * quantity[(i+1).toString()]!!

                    }

                    total_sum.text = (totalSumInt+(totPlaceInt* placePriceInt)).toString()
                }
            }

            override fun afterTextChanged(p0: Editable?) {

            }

        })

        edtt3.layoutParams=opl3.layoutParams

        edtt3.hint = "ціна"
        edtt3.textSize= 25f
        edtt3.isSingleLine=true
        edtt3.gravity=Gravity.CENTER
        edtt3.id=ViewGroup.generateViewId()
        edtt3.setBackgroundColor(Color.WHITE)
        edtt3.inputType=InputType.TYPE_CLASS_NUMBER
        linLayToaddPrice.addView(edtt3)
        quantity.put(edtt3.id.toString(), 0)

        edtt3.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            @RequiresApi(Build.VERSION_CODES.N)
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

                if (p0.toString() != "") {
                    quantity.set(edtt3.id.toString(), p0.toString().toInt())

                    totalSumInt = 0

                    for (i in 2..quantitycounter step 3) {
//                        println("size  " + quantity.size)
//                        println("price " + i.toString() + " = " + quantity[i.toString()]!!.toString())
//                        println("count " + (i + 1).toString() + " = " + quantity[(i + 1).toString()]!!.toString())
                        totalSumInt += quantity[i.toString()]!! * quantity[(i + 1).toString()]!!
                       // println("totSum = " + totalSumInt)
                    }

                    total_sum.text = (totalSumInt+(totPlaceInt* placePriceInt)).toString()
                }
                else {

                    quantity.set(edtt3.id.toString(), 0)

                    totalSumInt =0

                    for (i in 2..quantitycounter step 3) {

                        totalSumInt += quantity[i.toString()]!! * quantity[(i+1).toString()]!!

                    }

                    total_sum.text = (totalSumInt+(totPlaceInt* placePriceInt)).toString()
                }

            }

            override fun afterTextChanged(p0: Editable?) {

            }

        })

        linearLayoutToAddChapter.addView(linLayToaddPrice)
    }


}

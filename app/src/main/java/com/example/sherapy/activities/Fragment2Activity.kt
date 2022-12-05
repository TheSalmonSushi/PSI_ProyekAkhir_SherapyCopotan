package com.example.sherapy.activities

import android.os.Bundle
import android.os.CountDownTimer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.sherapy.R
import com.example.sherapy.databinding.Fragment2Binding
import java.util.*
import java.util.concurrent.TimeUnit
import kotlin.collections.ArrayList

class Fragment2Activity : Fragment() {

    private lateinit var binding: Fragment2Binding
    lateinit var questionsList:ArrayList<QuestionModel>
    private var index:Int = 0
    lateinit var questionModel: QuestionModel

    private var correctAnswerCount:Int=0

    lateinit var questions:TextView
    lateinit var option1: Button
    lateinit var option2:Button
    lateinit var option3:Button
    lateinit var option4:Button
    lateinit var countDown:TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = Fragment2Binding.inflate(layoutInflater, container, false)
        questions=binding.questions
        option1=binding.option1
        option2=binding.option2
        option3=binding.option3
        option4=binding.option4
        countDown=binding.countdown

        questionsList= ArrayList()
        questionsList.add(QuestionModel("What is actually electricity?","A flow of water","A flow of air","A flow of electrons"," A flow of atoms"))
        questionsList.add(QuestionModel("What is the speed of sound?","120 km/h","1,200 km/h","400 km/h","700 km/h"))
        questionsList.add(QuestionModel("What is the main component of the sun?","Liquid lava","Gas","Molten iron","Rock"))
        questionsList.add(QuestionModel("Which of the following animals can run the fastest?","Cheetah","Leopard","Tiger","Lion"))
        questionsList.add(QuestionModel("Which company is known for publishing the Mario video game?","Xbox","Nintendo","SEGA","Electronic Arts"))

        binding.option1.setOnClickListener {
                if (index < 4) {
                    index++
                    questionModel = questionsList[index]
                    setAllQuestions()
                } else {
                    findNavController().navigate(Fragment2ActivityDirections.actionFragment2ActivityToFragment3Activity())
                }
            }
            binding.option2.setOnClickListener {
                if (index < 4) {
                    index++
                    questionModel = questionsList[index]
                    setAllQuestions()
                } else {
                    findNavController().navigate(Fragment2ActivityDirections.actionFragment2ActivityToFragment3Activity())
                }
            }
            binding.option3.setOnClickListener {
                if (index < 4) {
                    index++
                    questionModel = questionsList[index]
                    setAllQuestions()
                } else {
                    findNavController().navigate(Fragment2ActivityDirections.actionFragment2ActivityToFragment3Activity())
                }
            }
            binding.option4.setOnClickListener {
                if (index < 4) {
                    index++
                    questionModel = questionsList[index]
                    setAllQuestions()
                } else {
                    findNavController().navigate(Fragment2ActivityDirections.actionFragment2ActivityToFragment3Activity())
                }
            }

        //questionsList.shuffle()
        questionModel= questionsList[index]
        setAllQuestions()
        countdown()

        return binding.root
    }

    fun countdown(){
        val duration:Long= TimeUnit.SECONDS.toMillis(20)

        object : CountDownTimer(duration, 1000) {
            override fun onTick(millisUntilFinished: Long) {

                val sDuration:String= String.format(
                    Locale.ENGLISH,
                    "%02d:%02d",
                    TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished),
                    TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished)-TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished)))
                countDown.text = sDuration
            }
            override fun onFinish() {
                index++
                if (index<questionsList.size){
                    questionModel=questionsList[index]
                    setAllQuestions()
                    resetBackground()
                    enableButton()
                    countdown()

                }
                else{
                    gameResult()

                }
            }
        }.start()
    }


    private fun correctAns(option: Button){
        option.background=resources.getDrawable(R.drawable.right_bg)
        correctAnswerCount++
    }

    private fun gameResult(){
        val bundle = Bundle()
        bundle.putString("correct",correctAnswerCount.toString())
        bundle.putString("total",questionsList.size.toString())

        val fragment = Fragment3Activity()
        fragment.arguments = bundle
    }

    private fun setAllQuestions() {
        questions.text=questionModel.question
        option1.text=questionModel.option1
        option2.text=questionModel.option2
        option3.text=questionModel.option3
        option4.text=questionModel.option4
    }
    private fun enableButton(){
        option1.isClickable=true
        option2.isClickable=true
        option3.isClickable=true
        option4.isClickable=true
    }
    private fun disableButton(){
        option1.isClickable=false
        option2.isClickable=false
        option3.isClickable=false
        option4.isClickable=false
    }
    private fun resetBackground(){
        option1.background=resources.getDrawable(R.drawable.btndeteksi)
        option2.background=resources.getDrawable(R.drawable.btndeteksi)
        option3.background=resources.getDrawable(R.drawable.btndeteksi)
        option4.background=resources.getDrawable(R.drawable.btndeteksi)
    }

}
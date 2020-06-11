package com.example.tictactoe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun click(view:View)
    {
        val bu = view as Button
        var cellid=0
        when(bu.id)
        {
            R.id.button ->cellid = 1
            R.id.button2 ->cellid = 2
            R.id.button3 ->cellid = 3
            R.id.button4 ->cellid = 4
            R.id.button5 ->cellid = 5
            R.id.button6 ->cellid = 6
            R.id.button7 ->cellid = 7
            R.id.button8 ->cellid = 8
            R.id.button9 ->cellid = 9

        }
//        Log.d("cellid",cellid.toString())
//        Log.d("buClicked",bu.id.toString())
        playgame(cellid,bu)

    }
    var activePlayer=1
    var player1= ArrayList<Int>()
    var player2=ArrayList<Int>()
    fun playgame(cellid:Int, bu:Button)
    {
        if(activePlayer==1)
        {
            bu.text="X"
            bu.setBackgroundResource(R.color.x)
            player1.add(cellid)
            activePlayer=2
            autoplay()
        }
        else
        {
            bu.text="O"
            bu.setBackgroundResource(R.color.o)
            player2.add(cellid)
            activePlayer=1
        }
        bu.isEnabled=false
        checkwinner()


    }
    fun checkwinner()
    {

        var winner=-1
        if(player1.contains(1) && player1.contains(2) && player1.contains(3))
            winner=1
        if(player2.contains(1) && player2.contains(2) && player2.contains(3))
            winner=2
        if (player1.contains(4) && player1.contains(5) && player1.contains(6))
            winner=1
        if(player2.contains(4) && player2.contains(5) && player2.contains(6))
            winner=2
        if(player1.contains(7) && player1.contains(8) && player1.contains(9))
            winner=1
        if (player2.contains(7) && player2.contains(8) && player2.contains(9))
            winner=2
        if(player1.contains(1) && player1.contains(4) && player1.contains(7))
            winner=1
        if(player2.contains(1) && player2.contains(4) && player2.contains(7))
            winner=2
        if(player1.contains(2) && player1.contains(5) && player1.contains(8))
            winner=1
        if(player2.contains(2) && player2.contains(5) && player2.contains(8))
            winner=2
        if(player1.contains(3) && player1.contains(6) && player1.contains(9))
            winner=1
        if(player2.contains(3) && player2.contains(6) && player2.contains(9))
            winner=2
        if(player1.contains(1) && player1.contains(5) && player1.contains(9))
            winner=1
        if(player2.contains(1) && player2.contains(5) && player2.contains(9))
            winner=2
        if(player1.contains(3) && player1.contains(5) && player1.contains(7))
            winner=1
        if(player2.contains(3) && player2.contains(5) && player2.contains(7))
            winner=2
        if(winner==1) {
            Toast.makeText(this, "PLAYER 1 WINS", Toast.LENGTH_LONG).show()
            restart()



        }

        else if(winner==2) {
            Toast.makeText(this, "PLAYER 2 WINS", Toast.LENGTH_LONG).show()
            restart()

        }

    }
    fun autoplay()
    {
        var emptycells= ArrayList<Int>()
        for(cellid in 1..9)
        {
            if(!(player1.contains(cellid) || player2.contains(cellid)))
            {
                emptycells.add(cellid)
            }
        }
        val r= Random()
        val ranIndex= r.nextInt(emptycells.size)
        val cellid=emptycells[ranIndex]

        var bu:Button?
        bu=when(cellid)
        {
            1-> button
            2-> button2
            3-> button3
            4-> button4
            5-> button5
            6-> button6
            7-> button7
            8-> button8
            9-> button9
            else->button

        }
        playgame(cellid,bu)

    }
    fun restart()
    {
        activePlayer=1
        player1.clear()
        player2.clear()
        for (cellid in 1..9) {
            var bu:Button?
            bu=when(cellid)
            {
                1-> button
                2-> button2
                3-> button3
                4-> button4
                5-> button5
                6-> button6
                7-> button7
                8-> button8
                9-> button9
                else->button

        }
            bu.text=""
            bu.setBackgroundResource(R.color.buttoncolor)
            bu.isEnabled=true
        }
    }


}

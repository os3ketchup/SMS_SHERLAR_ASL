package com.example.sms_sherlar

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.navigation.fragment.FragmentNavigatorExtras
import com.example.sms_sherlar.models.ItemPosition
import com.example.sms_sherlar.models.MyPoemAdapter
import com.example.sms_sherlar.models.Poems
import com.google.android.material.bottomsheet.BottomSheetDialog
import kotlinx.android.synthetic.main.fragment_types_of_poems.*
import kotlinx.android.synthetic.main.fragment_types_of_poems.view.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [TypesOfPoemsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class TypesOfPoemsFragment : Fragment() {
    lateinit var root:View
    lateinit var list: ArrayList<Poems>
    lateinit var myPoemAdapter: MyPoemAdapter
    var position = 0



    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        list = ArrayList()
        myPoemAdapter = MyPoemAdapter(list)
        root =  inflater.inflate(R.layout.fragment_types_of_poems, container, false)
        root.rv_tyOfPoems.adapter = myPoemAdapter



        list.add(Poems("Oshiq derlar meni1","1Sizni birinchi bor ko’rganimdayoq menga yoqib\n" +
                "qolgansiz, lekin bu tuyg’u sevgiga aylanadi deb\n" +
                "o’ylamagandim . . . ",1))
        list.add(Poems("Oshiq derlar meni2","2Sizni birinchi bor ko’rganimdayoq menga yoqib\n" +
                "qolgansiz, lekin bu tuyg’u sevgiga aylanadi deb\n" +
                "o’ylamagandim . . . ",2))
        list.add(Poems("Oshiq derlar meni3","3Sizni birinchi bor ko’rganimdayoq menga yoqib\n" +
                "qolgansiz, lekin bu tuyg’u sevgiga aylanadi deb\n" +
                "o’ylamagandim . . . ",3))
        list.add(Poems("Oshiq derlar meni4","4Sizni birinchi bor ko’rganimdayoq menga yoqib\n" +
                "qolgansiz, lekin bu tuyg’u sevgiga aylanadi deb\n" +
                "o’ylamagandim . . . ",4))
        list.add(Poems("Oshiq derlar meni5","5Sizni birinchi bor ko’rganimdayoq menga yoqib\n" +
                "qolgansiz, lekin bu tuyg’u sevgiga aylanadi deb\n" +
                "o’ylamagandim . . . ",5))
        list.add(Poems("Oshiq derlar meni6","6Sizni birinchi bor ko’rganimdayoq menga yoqib\n" +
                "qolgansiz, lekin bu tuyg’u sevgiga aylanadi deb\n" +
                "o’ylamagandim . . . ",6))
        list.add(Poems("Oshiq derlar meni7","7Sizni birinchi bor ko’rganimdayoq menga yoqib\n" +
                "qolgansiz, lekin bu tuyg’u sevgiga aylanadi deb\n" +
                "o’ylamagandim . . . ",7))
        val sheetDialog = BottomSheetDialog(root.context)
        myPoemAdapter.setOnItemClickListener(object:MyPoemAdapter.OnItemClickListener{
            override fun onItemClick(position: Int) {
                    sheetDialog.setContentView(
                        layoutInflater.inflate(
                            R.layout.fragment_my_poem_dialog,
                            null,
                            false
                        )


                    )
                    bundleOf("key" to position)

                    sheetDialog.show()

            }
        })
        return root
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment TypesOfPoemsFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            TypesOfPoemsFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}


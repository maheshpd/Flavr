package com.example.flavr.fragment


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.flavr.Interface.IFirebaseLoaderListener
import com.example.flavr.R
import com.example.flavr.model.CategoryModel
import com.google.firebase.firestore.FirebaseFirestore

/**
 * A simple [Fragment] subclass.
 */
class Categories : Fragment(), IFirebaseLoaderListener {

    lateinit var iFirebaseLoaderListener: IFirebaseLoaderListener
    lateinit var myCateData: FirebaseFirestore

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_categories, container, false)
        val category_rv: RecyclerView? = view?.findViewById(R.id.categories_rv)
        myCateData = FirebaseFirestore.getInstance()

        iFirebaseLoaderListener = this

        getCategoryData()

        return view
    }

    private fun getCategoryData() {
        myCateData.collection("")
            .get()
            .addOnSuccessListener { result ->
                for (document in result) {
                }
            }
    }

    override fun onFirebaseLoadListener(categoryItem: List<CategoryModel>) {
    }

    override fun onFirebaseLoadFailed(message: String) {

    }


}

package com.sabin.softuser.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import com.sabin.softuser.R

class WebFragment : Fragment() {

    private lateinit var webView : WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_web, container, false)

        webView = view.findViewById(R.id.webView)
        webView.loadUrl("https://softwarica.edu.np/");

    return view
        }
//    override fun onBackPressed(){
//        if(webView!!.canGoBack()){
//            webView.goBack()
//        } else {
//            super.onBackPressed()
//        }
//    }
}
package com.example.otchallenge.ui.bookslisting

import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.otchallenge.MyApplication
import com.example.otchallenge.R
import com.example.otchallenge.data.model.Book
import com.example.otchallenge.databinding.ActivityBooksBinding
import com.example.otchallenge.utils.SpacingInRecyclerView

class BooksActivity : AppCompatActivity(), BooksMvpView {

	lateinit var mAdapter: BooksListingAdapter
	private lateinit var binding: ActivityBooksBinding
	lateinit var mPresenter: BooksPresenter<BooksMvpView>

	override fun onCreate(savedInstanceState: Bundle?) {
		(application as MyApplication).applicationComponent.inject(this)
		super.onCreate(savedInstanceState)
		enableEdgeToEdge()
		binding = DataBindingUtil.setContentView(this, R.layout.activity_books)
		binding.view = this

		ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
			val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
			v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
			insets
		}
		inIt()
	}

	private fun inIt() {
		val mBooksUseCase = (application as MyApplication).applicationComponent.getBooksUseCase()
		mPresenter = BooksPresenter(this, mBooksUseCase)
		setupRecyclerView()
		mPresenter.getBooks()
		binding.refreshLayout.setOnRefreshListener {
			mPresenter.getBooks()
		}
	}

	private fun setupRecyclerView() {
		mAdapter = BooksListingAdapter()
		binding.recyclerView.apply {
			layoutManager = LinearLayoutManager(this@BooksActivity)
			adapter = mAdapter
			addItemDecoration(
				SpacingInRecyclerView(spacing = 8,
				separatorHeight = 2,
				separatorColor = Color.GRAY))
		}
	}

	override fun showLoading(isLoading: Boolean) {
		binding.refreshLayout.isRefreshing = isLoading
	}

	override fun displayBooks(mBooks: List<Book>?, title: String?) {
		binding.apply {
			errorLayout.visibility = View.GONE
			refreshLayout.visibility = View.VISIBLE
			mAdapter.saveData(mBooks)
			booksTitle.text = title
		}

	}

	override fun showError(error: String) {
		binding.apply {
			errorLayout.visibility = View.VISIBLE
			refreshLayout.visibility = View.GONE
			errorMessage.text = error
		}
	}

	fun reLoad(view:View) {
		mPresenter.getBooks()
	}
}

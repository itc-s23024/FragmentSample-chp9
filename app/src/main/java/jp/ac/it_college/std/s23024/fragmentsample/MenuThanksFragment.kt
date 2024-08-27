package jp.ac.it_college.std.s23024.fragmentsample

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import jp.ac.it_college.std.s23024.fragmentsample.databinding.FragmentMenuThanksBinding


class MenuThanksFragment : Fragment() {
    private var _binding: FragmentMenuThanksBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMenuThanksBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // apply スコープ関数を使って記述を簡略化
        binding.apply {
            // 定食名
            tvMenuName.text = arguments?.getString("menuName") ?: "よく分からない定食"
            // 価格
            tvMenuPrice.text = (arguments?.getInt("menuPrice") ?: 999999).toString()

            // 戻るボタンのクリックイベント
            btThxBack.setOnClickListener {
                // 旧式
                // フラグメントのスタック履歴の1個前へ戻る
//                parentFragmentManager.popBackStack()

                // お行儀よくアクティビティへ結果を返す。
                parentFragmentManager.setFragmentResult(
                    "backToList", Bundle()
                )
            }
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
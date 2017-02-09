package com.qwh.type_label;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * com.qwh.type_label
 * 开发者 qwh
 * 时间: 11:48
 * 邮箱:2529509180@qq.com
 * 自定义标签
 */

public class TypeLabelView extends RelativeLayout {
    private labelClickListener mLabelClickListener;

    private RelativeLayout rlType;
    private ImageView ivLeft, ivRight;
    private TextView tvName;

    public TypeLabelView(Context context) {
        super(context);
        initView(context, null);
    }

    public TypeLabelView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context, attrs);
    }

    public TypeLabelView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context, attrs);
    }

    private void initView(Context context, AttributeSet attrs) {
        LayoutInflater.from(context).inflate(R.layout.custom_type_layout, this);
        rlType = (RelativeLayout) findViewById(R.id.rl_custom_type_label);
        ivLeft = (ImageView) findViewById(R.id.iv_custom_type_label_left);
        ivRight = (ImageView) findViewById(R.id.iv_custom_type_label_right);
        tvName = (TextView) findViewById(R.id.tv_custom_type_label_name);
        if (attrs != null) {
            TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.type_label);
            String name = ta.getString(R.styleable.type_label_label_name);
            Drawable drawableLeft = ta.getDrawable(R.styleable.type_label_label_left);
            Drawable drawableRight = ta.getDrawable(R.styleable.type_label_label_right);
            int nameColor = ta.getColor(R.styleable.type_label_label_name_color, 0);
            tvName.setText(name);
            if (nameColor != 0)
                tvName.setTextColor(nameColor);
            if (drawableLeft != null)
                ivLeft.setImageDrawable(drawableLeft);
            if (drawableRight != null)
                ivRight.setImageDrawable(drawableRight);
            ta.recycle();

        }
        rlType.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                mLabelClickListener.clickListener();
            }
        });

    }

    /**
     * 设置左按钮背景
     *
     * @param resId
     */
    public void setLefttImageResource(int resId) {
        ivLeft.setImageResource(resId);
    }

    /**
     * 设置右按钮背景
     *
     * @param resId
     */
    public void setRighttImageResource(int resId) {
        ivRight.setImageResource(resId);
    }

    /**
     * 设置标题
     */
    public void setTitleText(String text) {
        tvName.setText(text);
    }


    /**
     * 设置标题颜色
     */
    public void setTitleTextColor(int color) {
        tvName.setTextColor(color);
    }

    /**
     * 设置背景颜色
     *
     * @param color
     */
    public void setBackground(int color) {
        rlType.setBackgroundColor(getResources().getColor(color));
    }

    /**
     * 设置左按钮是否可见 true为可见 flase为不可见（GONE）
     *
     * @param flag
     */
    public void setLeftIsVisable(boolean flag) {
        if (flag) {
            ivLeft.setVisibility(View.VISIBLE);
        } else {
            ivLeft.setVisibility(View.GONE);
        }

    }

    /**
     * 设置右按钮是否可见 true为可见 flase为不可见（GONE）
     *
     * @param flag
     */
    public void setRightIsVisable(boolean flag) {
        if (flag) {
            ivRight.setVisibility(View.VISIBLE);
        } else {
            ivRight.setVisibility(View.GONE);
        }
    }


    public void setLabelHeight(int height) {
    }

    public void setLabelCickListener(labelClickListener mLabelCickListener) {
        this.mLabelClickListener = mLabelCickListener;
    }
}

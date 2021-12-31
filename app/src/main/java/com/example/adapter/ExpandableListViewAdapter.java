package com.example.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.example.model.GroupObject;
import com.example.model.ItemObject;
import com.example.btheb.R;

import java.util.List;
import java.util.Map;

public class ExpandableListViewAdapter extends BaseExpandableListAdapter {
    private List<GroupObject> mListGroup;
    private Map<GroupObject, List<ItemObject>> mListItem;

    public ExpandableListViewAdapter(List<GroupObject> mListGroup, Map<GroupObject, List<ItemObject>> mListItem) {
        this.mListGroup = mListGroup;
        this.mListItem = mListItem;
    }

    @Override
    public int getGroupCount() {
        if (mListGroup != null){
            return mListGroup.size();

        }
        return 0;
    }

    @Override
    public int getChildrenCount(int i) {
        if (mListGroup != null && mListItem != null){
            return mListItem.get(mListGroup.get(i)).size();
        }
        return 0;
    }

    @Override
    public Object getGroup(int i) {
        return mListGroup.get(i);
    }

    @Override
    public Object getChild(int i, int i1) {
        return mListItem.get(mListGroup.get(i)).get(i1);
    }

    @Override
    public long getGroupId(int i) {
        GroupObject groupObject =mListGroup.get(i);
        return groupObject.getId();
    }

    @Override
    public long getChildId(int i, int i1) {
        ItemObject itemObject = mListItem.get(mListGroup.get(i)).get(i1);
        return itemObject.getIdItem();
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
        if (view == null){
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_parent_search_layout, viewGroup, false);
        }

        TextView tvItemGroup = view.findViewById(R.id.tvItemGroup);
        GroupObject groupObject = mListGroup.get(i);
        tvItemGroup.setText(groupObject.getName());

        return view;
    }

    @Override
    public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_child_search, viewGroup, false);

        }

        TextView tvItem = view.findViewById(R.id.tvItem);
        ItemObject itemObject = mListItem.get(mListGroup.get(i)).get(i1);
        tvItem.setText(itemObject.getNameItem());

        return view;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return true;
    }
}
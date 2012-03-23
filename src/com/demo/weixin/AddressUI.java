/**
 * 
 */
package com.demo.weixin;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

/**
 * @author huchenpeng
 *
 */
public class AddressUI extends MMActivity{

    /* (non-Javadoc)
     * @see com.demo.weixin.MMActivity#bodyView()
     */
    @Override
    protected int bodyView() {
        // TODO Auto-generated method stub
        return R.layout.address;
    }

    
    public void onCreate(Bundle bundle){
        super.onCreate(bundle);
        setRightButtonText(R.string.address_multi_select_opt);
        setTitleText(R.string.group_weixin);
        View searchBar= View.inflate(this, R.layout.search_bar, null);//search_bar
        EditText edittext = (EditText)searchBar.findViewById(R.id.search_bar_et);//search_bar_et
        Button search_clear_bt = (Button)searchBar.findViewById(R.id.search_clear_bt);//search_clear_bt
        edittext.setCompoundDrawablesWithIntrinsicBounds(R.drawable.search_bar_icon_normal, 0, 0, 0);//search_bar_icon_normal
        
        ListView listView = (ListView)findViewById(R.id.address_contactlist);//address_contactlist
        listView.addHeaderView(searchBar);
    }
}

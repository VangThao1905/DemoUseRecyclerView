package vangthao.app.demouserecyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ContactsAdapter extends RecyclerView.Adapter<ContactsAdapter.ViewHolder> {

    private List<Contact> mContacts;

    public class ViewHolder extends RecyclerView.ViewHolder {
        private Context context;
        public TextView txtName;
        public Button btnMessage;

        public ViewHolder(Context context, View itemView) {
            super(itemView);
            this.context = context;
            this.txtName = itemView.findViewById(R.id.contact_name);
            this.btnMessage = itemView.findViewById(R.id.btnMessage);
        }
    }

    public ContactsAdapter(List<Contact> mContacts) {
        this.mContacts = mContacts;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View contactView = inflater.inflate(R.layout.item_contacts, parent, false);

        ViewHolder viewHolder = new ViewHolder(context, contactView);


        viewHolder.btnMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "" + viewHolder.txtName.getText(), Toast.LENGTH_SHORT).show();
            }
        });
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Contact contact = mContacts.get(position);

        TextView textView = holder.txtName;
        textView.setText(contact.getmName());
        Button btnMessage = holder.btnMessage;
        btnMessage.setText(contact.ismOnline() ? "Message" : "Offline");
        btnMessage.setEnabled(contact.ismOnline());
    }

    @Override
    public int getItemCount() {
        return mContacts.size();
    }

}

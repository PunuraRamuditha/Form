import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;



public class InputData {
        StringProperty DataFname = new SimpleStringProperty();
        StringProperty DataLname = new SimpleStringProperty();
        StringProperty DataEmail = new SimpleStringProperty();
        StringProperty DataContact = new SimpleStringProperty();
        StringProperty DataHandler = new SimpleStringProperty();

        public final StringProperty DataHandlerProperty() {
            return this.DataHandler;
        }

        public final java.lang.String getDataHandler() {
            return this.DataHandlerProperty().get();
        }

        public final void setDataHandler(final java.lang.String DataHandler) {
            this.DataHandlerProperty().set(DataHandler);
        }

        public final StringProperty DataFnameProperty() {
            return this.DataFname;
        }

        public final java.lang.String getDataFname() {
            return this.DataFnameProperty().get();
        }

        public final void setDataFname(final java.lang.String DataName) {
            this.DataFnameProperty().set(DataName);
        }

        public final StringProperty DataLnameProperty() {
            return this.DataLname;
        }

        public final java.lang.String getDataLname() {
            return this.DataLnameProperty().get();
        }

        public final void setDataLname(final java.lang.String DataLname) {
            this.DataLnameProperty().set(DataLname);
        }

        public final StringProperty DataEmailProperty() {
            return this.DataEmail;
        }

        public final java.lang.String getDataEmail() {
            return this.DataEmailProperty().get();
        }

        public final void setDataEmail(final java.lang.String DataEmail) {
            this.DataEmailProperty().set(DataEmail);
        }

        public final StringProperty DataContactProperty() {
            return this.DataContact;
        }

        public final java.lang.String getDataContact() {
            return this.DataContactProperty().get();
        }

        public final void setDataContact(final java.lang.String DataContact) {
            this.DataContactProperty().set(DataContact);
        }
        
}


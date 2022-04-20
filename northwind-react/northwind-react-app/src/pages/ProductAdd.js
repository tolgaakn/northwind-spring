import { ErrorMessage, Field, Form, Formik } from "formik";
import * as Yup from 'yup';
import React from "react";
import { Button, FormField, Label } from "semantic-ui-react";
import NwTextInput from "../utilities/customFormControls/NwTextInput";

export default function ProductAdd() {
    const initialValues = { productName: "", unitPrice: 0 };
    const schema = Yup.object({
        productName: Yup.string().required("Ürün adı zorunlu"),
        unitPrice: Yup.number().required("Ürün fiyatı zorunlu")
    })
    return (
        <div>
            <Formik
                initialValues={initialValues}
                validationSchema={schema}
                onSubmit = {(values) => {
                    console.log(values);
                }}
            >
                <Form className="ui form">
                    <NwTextInput name="productName" placeholder="Ürün Adı"></NwTextInput>
                    <NwTextInput name="unitPrice" placeholder="Ürün Fiyatı"></NwTextInput>
                    <Button color="green" type="submit">Ekle</Button>
                </Form>
            </Formik>
        </div>
    );
}

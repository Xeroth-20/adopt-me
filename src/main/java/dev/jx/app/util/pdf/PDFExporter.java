package dev.jx.app.util.pdf;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface PDFExporter<T> {

    void export(T object, HttpServletResponse response) throws IOException;
}

package autorep.views.window;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.ColumnViewerToolTipSupport;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.window.ToolTip;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Text;


public class LyapasSymbols extends ViewPart {
      //  public static final String ID = "de.vogella.jface.tableviewer.view";

        private TableViewer viewer;
        // static fields to hold the images
       
        public void createPartControl(Composite parent) {
                GridLayout layout = new GridLayout(2, false);
                parent.setLayout(layout);
                Label searchLabel = new Label(parent, SWT.NONE);
                searchLabel.setText("Search: ");
                final Text searchText = new Text(parent, SWT.BORDER | SWT.SEARCH);
                searchText.setLayoutData(new GridData(GridData.GRAB_HORIZONTAL
                                | GridData.HORIZONTAL_ALIGN_FILL));
                createViewer(parent);
        }

        private void createViewer(Composite parent) {
                viewer = new TableViewer(parent, SWT.MULTI | SWT.H_SCROLL
                                | SWT.V_SCROLL | SWT.FULL_SELECTION | SWT.BORDER);
                createColumns(parent, viewer);
                final Table table = viewer.getTable();
                table.setHeaderVisible(true);
                table.setLinesVisible(true);

                viewer.setContentProvider(new ArrayContentProvider());
                // get the content for the viewer, setInput will call getElements in the
                // contentProvider
                viewer.setInput(ModelProvider.INSTANCE.getLSymbols());
                // make the selection available to other views
                getSite().setSelectionProvider(viewer);
                // set the sorter for the table

                // define layout for the viewer
                GridData gridData = new GridData();
                gridData.verticalAlignment = GridData.FILL;
                gridData.horizontalSpan = 2;
                gridData.grabExcessHorizontalSpace = true;
                gridData.grabExcessVerticalSpace = true;
                gridData.horizontalAlignment = GridData.FILL;
                viewer.getControl().setLayoutData(gridData);
        }

        
        public TableViewer getViewer() {
                return viewer;
        }

        
        // create the columns for the table
        private void createColumns(final Composite parent, final TableViewer viewer) {
                String[] titles = { "Symbol", "Name", "HotKey" };
                int[] bounds = { 100, 250, 100 };

                ColumnViewerToolTipSupport.enableFor(viewer, ToolTip.NO_RECREATE);
     
                TableViewerColumn col = createTableViewerColumn(titles[0], bounds[0], 0);
                col.setLabelProvider(new ColumnLabelProvider() {
                        @Override
                        public String getText(Object element) {
                                LSymbol p = (LSymbol) element;
                                return p.getSymbol();
                        }
                        
                        public String getToolTipText(Object element) {
                            return ((LSymbol)element).getToolTips();
                          }

                          @Override
                          public Point getToolTipShift(Object object) {
                            return new Point(5, 5);
                          }

                          @Override
                          public int getToolTipDisplayDelayTime(Object object) {
                            return 100; // msec
                          }

                          @Override
                          public int getToolTipTimeDisplayed(Object object) {
                            return 5000; // msec
                          }
                });

       
                col = createTableViewerColumn(titles[1], bounds[1], 1);
                col.setLabelProvider(new ColumnLabelProvider() {
                        @Override
                        public String getText(Object element) {
                        	LSymbol p = (LSymbol) element;
                                return p.getName();
                        }
                });

        
                col = createTableViewerColumn(titles[2], bounds[2], 2);
                col.setLabelProvider(new ColumnLabelProvider() {
                        @Override
                        public String getText(Object element) {
                        	LSymbol p = (LSymbol) element;
                                return p.getHotKey();
                        }
                });

        }

        private TableViewerColumn createTableViewerColumn(String title, int bound, final int colNumber) {
                final TableViewerColumn viewerColumn = new TableViewerColumn(viewer,
                                SWT.NONE);
                final TableColumn column = viewerColumn.getColumn();
                column.setText(title);
                column.setWidth(bound);
                column.setResizable(true);
                column.setMoveable(true);
                return viewerColumn;
        }

        public void setFocus() {
                viewer.getControl().setFocus();
        }
}

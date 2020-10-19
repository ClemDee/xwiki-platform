/*
 * See the NOTICE file distributed with this work for additional
 * information regarding copyright ownership.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */


/**
 * The filterMixin is a vue mixin containing all the needed
 * props, computed values, methods, etc. for any custom filter:
 * `propertyId`, `index`, `filterEntry`, `config`, `applyFilter()`, ...
 * It should be included in every custom filter component
 */
export default {

  inject: ["logic"],

  props: {
    propertyId: String,
    index: Number,
  },

  // The computed values provide common data needed by filters
  computed: {
    // The filter group (the whole filter configuration) of `this.propertyId`
    filterGroup () {
      return this.logic.filters.getQueryFilterGroup(this.propertyId) || {};
    },
    // The filter entry (the filter at `this.index`) of `this.propertyId`
    filterEntry () {
        return (this.filterGroup.constrains || [])[this.index] || {};
    },
    // The property descriptor of `this.propetyId`
    propertyDescriptor () {
      return this.logic.properties.getDescriptor({ propertyId: this.propertyId });
    },
    // The configuration (aka filterDescriptor) of the filter
    filterConfig () {
      return this.logic.filters.getDescriptorFromProperty(this.propertyId);
    },
    // The whole Livedata config object
    config () {
      return this.logic.config;
    },
  },

  methods: {
    // This method should be used to apply filter
    // As only the newValue has to be specified it is less error prone
    applyFilter (newValue) {
      this.logic.filters.filter(this.propertyId, this.index, {value: newValue});
    },
  },

};
